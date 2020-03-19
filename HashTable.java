/*Emma Gertje
 * 3/19/2020
 * CSCI 271
 * Professor David Keil
 * Competency 3.3c - Implement a hash table
 * This is an implementation of a Hash Table which will use bucket-based
 * 		hashing to implement a hash table of cylinders which will have a key value 
 * 		which will be an String. This hash table has a hash function for strings,
 * 		can get a HashNode, delete one, or update or add a node to the table
 */
import java.util.LinkedList;
 
public class HashTable {
	public static final int TABLE_SIZE = 128;
    private LinkedList<HashNode>[] table = new LinkedList[TABLE_SIZE];
    //constructor
    public HashTable() {
        //initial values in the hash table by setting all the buckets
    		//to null since they're all empty
        for(int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }
    /**
     * This gets the HashNode in the hash table associated with the given key.
     * This is a helper function for the get method.
     * @param key the key of the HashNode we are trying to get
     * @return the HashNode we are trying to get
     */
    private HashNode getHelper(String key) {
    	//first check to see if the key is null because it can't be null
        if(key == null) {
            return null;
        }
        //now use the hash function to find the hash code for the string
        int index = hash(key);
        LinkedList<HashNode> bucket = table[index];
        //if the bucket for the given key is null then the HashNode is not in the table
        	//and we must return null
        if(bucket == null) {
            return null;
        }
        //if the bucket isn't null then we will check to see if it's in the bucket
        for(HashNode currentNode : bucket) {
            if(currentNode.key.equals(key)) {
                return currentNode;
            }
        }
        //if the node associated with the key isn't in the bucket we will return null
        return null;
    }
    /**
	  * Get the Cylinder object which is the value associated with the given
	  * key.
	  * @param key the key of the Cylinder object we are trying to find
	  * @return a Cylinder which matches up to the specified key
	  */
    public Cylinder get(String key) {
        HashNode currentNode = getHelper(key);
        //if a HashNode with the given key isn't in the hash table then return null
        if(currentNode == null) {
            return null;
        }
        else {
            return currentNode.value;
        }
    }
    /**
	  * This method adds a HashNode to the HashTable or updates a current HashNode in
	  * the table
	  * @param key the key of the HashNode being added or updated
	  * @param value the Cylinder value of the HashNode being added or updated
	  */
    public void put(String key, Cylinder value) {
    	//initialize the new node
    	HashNode newNode = new HashNode(key, value);
    	//first find where to put the HashNode by finding its hash code
        int index = hash(key);
        //now find the bucket for that hash code
        LinkedList<HashNode> bucket = table[index];
        //first see if the bucket is empty
        if(bucket == null) {
        	//now make a new list of HashNodes
            bucket = new LinkedList<HashNode>();
            //now add the node to the list 
            bucket.add(newNode);
            //now update the bucket for that index
            table[index] = bucket;
        }
        else {
        	//first check to see if a node with that key already exists
            for(HashNode currentNode : bucket) {
                if(currentNode.key.equals(key)) {
                	//if a node with that key exists just update the value
                    currentNode.value = value;
                    return;
                }
            }
            //if a node with that key doesn't exist add the new node to the bucket
            bucket.add(newNode);
        }
    }
    /**
	  * Delete a node from the hash table with the given key
	  * @param key the key of the node we are deleting
	  */
    public void delete(String key) {
        int index = hash(key);
        LinkedList<HashNode> bucket = table[index];
        //first check to see if the bucket is empty because if it is a node with that
        	//key is not in the table so nothing happens
        if(bucket == null) {
        	System.out.printf("%s was not a key associated with a node in the hash table", key);
            return;
        }
        //if the bucket isn't empty search the list to see if a node with that key exists
        for(HashNode currentNode : bucket) {
            if (currentNode.key.equals(key)) {
                bucket.remove(currentNode);
                System.out.printf("HashNode with key %s is now deleted%n", key);
                return;
            }
        }
        //If I go through everything in the list and a node with they key is not there
        	//then I will print out this message saying there was no node with that 
        	//key in the hash table
        System.out.printf("%s was not a key associated with a node in the hash table", key);
    }
    /**
	  * This produces a hash code for a key that is a String so we know
	  * where to store the HashNode in the hash table
	  * @param key the key we are trying to produce a hash code for
	  * @return an int which is the hash code for the given key
	  */
    public static int hash(String key) {
		//this hash function accommodates for overflow
	    int y = 0;
	    for(int i = 0; i < key.length(); i++) {
	    	y = 41 * y + key.charAt(i);
	    }
	    y %= TABLE_SIZE;
	    //if there is overflow, I will do this
	    if(y < 0) {
	    	y += TABLE_SIZE; //corrects overflow
	    }
	    return y;
	 }
 
}