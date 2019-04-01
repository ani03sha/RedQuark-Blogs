package org.redquark.java.miscellaneous.accessmodifiers;

/**
 * @author Anirudh Sharma
 *
 */
public class AccessModifierOnClasses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creating the object of the class
		AccessModifierOnClasses accessModifierOnClasses = new AccessModifierOnClasses();

		// Getting object of the private inner class using the object of the parent class - AccessModifierOnClasses
		PrivateClassExample privateClassExample = accessModifierOnClasses.new PrivateClassExample();

		// Calling the method in private inner class
		privateClassExample.method1();

		// Getting object of the protected inner class using the object of the parent class - AccessModifierOnClasses
		ProtectedClassExample protectedClassExample = accessModifierOnClasses.new ProtectedClassExample();

		// Calling the method in private inner class
		protectedClassExample.method2();
	}

	/**
	 * 
	 * @author Anirudh Sharma
	 *
	 */
	private class PrivateClassExample {

		private void method1() {

			System.out.println("Inside the private inner class");
		}
	}

	/**
	 * 
	 * @author Anirudh
	 *
	 */
	protected class ProtectedClassExample {

		private void method2() {

			System.out.println("Inside the protected inner class");
		}
	}

}
