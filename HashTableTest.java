/*Emma Gertje
 * 3/19/2020
 * CSCI 271
 * Professor David Keil
 * Competency 3.3c - Implement a hash table
 * This tests the implementation of the hash table I wrote
 */
public class HashTableTest {
	public static void main(String[] args) {
		HashTable table1 = new HashTable();
		//create several cylinder objects
		Cylinder c1 = new Cylinder(4, 5);
		Cylinder c2 = new Cylinder(1.2, 8.3);
		Cylinder c3 = new Cylinder(7.2, 2);
		Cylinder c4 = new Cylinder(15.4, 87.3);
        table1.put("awesome", c1); 
        table1.put("jfdakje3alfkj", c2); 
        table1.put("data structures", c3); 
        table1.put("akdfjkeka44487", c4);  
        System.out.println(table1.get("awesome")); 
        System.out.println(table1.get("data structures")); 
        System.out.println(table1.get("akdfjkeka44487")); 
        table1.delete("awesome");
        table1.delete("random");
	}

}
