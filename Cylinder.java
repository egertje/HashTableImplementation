/* Emma Gertje
 * 2/2/2020
 * CSCI 271
 * Professor David Keil
 * Competency 0.1e - Define and test a class
 * This is a class that holds the radius and height of a cylinder. 
 * 		It also calculates the volume and surface area of
 *		the cylinder and has accessors, mutators,
 *		and appropriate I/O methods such as reading and writing to text files
 */

import java.util.*;
import java.io.*;
import java.lang.Math;

public class Cylinder {
	private double radius;
	private double height;
	
	//constructors
	public Cylinder() {
		this.radius = 1;
		this.height = 1;
	}

	public Cylinder(double r, double h) {
		this.radius = r;
		this.height = h;
	}
	
	//mutators
	public void setRadius(double r) {
		this.radius = r;
	}
	public void setHeight(double h) {
		this.height = h;
	}
	
	//accessors
	public double getRadius() {
		return radius;
	}
	public double getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @return a double that is the volume of the cylinder
	 */
	public double calculateVolume() {
		return radius*radius*height*Math.PI;
	}
	
	/**
	 * 
	 * @return a double that is the surface area of the cylinder
	 */
	public double calculateSurfaceArea() {
		return (2*radius*radius*Math.PI) + (2*Math.PI*radius*height);
	}
	
	//I/O
	public String toString() {
		return String.format("radius: %.2f, height: %.2f%n", radius, height);
	}
	
	public boolean equals(Object obj) {
		//checking to see if both the object references are referencing 
			//the same object
		if(obj == this) {
			return true;
		}
		//checks to see if the object is of type Cylinder
		if(obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Cylinder cylinder = (Cylinder) obj;
		//checks to see if the state of the two objects are the same
		return (cylinder.radius == this.radius && cylinder.height == this.height);
	}

	public void fileWrite(PrintWriter fout) {
		fout.println(toString());
	}
	
	public boolean fileRead(Scanner fin) {
		if(fin.hasNextDouble()) {
			radius = fin.nextDouble();
			height = fin.nextDouble();
			return true;
		}
		else {
			return false;
		}
	}
}
