package org.redquark.java.miscellaneous.variables;

/**
 * @author Anirudh Sharma
 *
 */
public class TypesOfVariables {

	// instance variable
	private int instanceVarible;

	// static variable
	public static int staticVariable = 30;

	public static void main(String args[]) {

		// local variable - accessed only in the main method
		int localVariable = 100;

		// creating an instance of the class to access the instance variable
		TypesOfVariables obj = new TypesOfVariables();

		// usage of all three types of variables
		System.out.println("Value of instance variable instanceVarible: " + obj.instanceVarible);
		System.out.println("Value of static variable staticVariable: " + TypesOfVariables.staticVariable);
		System.out.println("Value of local variable localVariable: " + localVariable);
	}
}
