
/*Emma Gertje
 * 3/17/2020
 * CSCI 271
 * Professor David Keil
 * Competency 3.3c - Implement a hash table
 * This is an implementation of a Hash Table node which will use bucket-based
 * 		hashing to implement a hash table of cylinders which will have a key value 
 * 		which will be an String.
 */
public class HashNode {
	String key;
	Cylinder value;
	
	//constructors
	public HashNode() {
		key = "0";
		value = new Cylinder();
	}
	public HashNode(String k, Cylinder v) {
		this.key = k;
		this.value = v;
	}
	
	//toString method
	public String toString() {
		return String.format("key: %s%nvalue: %s%n", key, value.toString());
	}
}
