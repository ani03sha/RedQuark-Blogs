package org.redquark.java.miscellaneous.numbersystems;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class NumberSystemConversion {

	public static void main(String[] args) {

		// Create a scanner instance to get the input from the user
		Scanner input = new Scanner(System.in);

		// Get the binary number which needs to be converted into decimal
		int binary = Integer.parseInt(input.next());

		// Converting binary to decimal
		System.out.println("Binary to Decimal: " + binary + " ==> " + binaryToDecimal(binary));

		// Get the octal number which needs to be converted into decimal
		int octal = Integer.parseInt(input.next());

		// Converting octal to decimal
		System.out.println("Octal to Decimal: " + octal + " ==> " + octalToDecimal(octal));

		// Get the octal number which needs to be converted into decimal
		String hexadecimal = input.next();

		// Converting octal to decimal
		System.out.println("Octal to Decimal: " + hexadecimal + " ==> " + hexadecimalToDecimal(hexadecimal));

		// Get the decimal which needs to be converted into other number systems
		int decimal = input.nextInt();

		// Converting decimal to binary
		decimalToBinary(decimal);

		// Converting decimal to octal
		decimalToOctal(decimal);

		// Converting decimal to hexadecimal
		decimalToHexadecimal(decimal);

		// Closing the Scanner to avoid memory leaks
		input.close();
	}

	/**
	 * This method accepts binary argument and convert it into decimal
	 * 
	 * @param binary
	 * @return decimal equivalent
	 */
	private static int binaryToDecimal(int binary) {

		// Decimal equivalent
		int decimal = 0;

		// The place determines the exponent of 2
		int place = 0;

		// Divide the number by 10 until true
		while (true) {

			if (binary == 0) {
				break;
			} else {

				int temp = binary % 10;

				// Decimal should be added to its previous value and the 2 raised to the power
				// place
				decimal += temp * Math.pow(2, place);

				// Move to more significant digit
				binary = binary / 10;

				// Increment place for more significant digit
				place++;
			}
		}

		return decimal;
	}

	/**
	 * This method converts decimal input to its binary equivalent
	 * 
	 * @param decimal
	 */
	private static void decimalToBinary(int decimal) {

		// Array that will store the binary digits
		int[] binary = new int[40];

		// This variable will store the index of each binary digit
		int index = 0;

		// Divide the decimal by 2 until possible
		while (decimal > 0) {

			// Remainders after dividing the decimal by 2 will be stored
			binary[index++] = decimal % 2;

			// Move forward
			decimal = decimal / 2;

		}

		System.out.print("Decimal to Binary: ");
		// Prints the binary digits in the reverse order
		for (int i = index - 1; i >= 0; i--) {

			System.out.print(binary[i]);
		}
		System.out.println("\n");
	}

	/**
	 * This method converts octal number to its decimal equivalent
	 * 
	 * @param octal
	 * @return decimal equivalent
	 */
	private static int octalToDecimal(int octal) {

		// Decimal equivalent
		int decimal = 0;

		// The place determines the exponent of 8
		int place = 0;

		// Divide the number by 10 until true
		while (true) {

			if (octal == 0) {
				break;
			} else {

				int temp = octal % 10;

				// Decimal should be added to its previous value and the 8 raised to the power
				// place
				decimal += temp * Math.pow(8, place);

				// Move to more significant digit
				octal = octal / 10;

				// Increment place for more significant digit
				place++;
			}
		}

		return decimal;
	}

	/**
	 * This method converts decimal input to its octal equivalent
	 * 
	 * @param decimal
	 */
	private static void decimalToOctal(int decimal) {

		// Array that will store the binary digits
		int[] octal = new int[40];

		// This variable will store the index of each binary digit
		int index = 0;

		// Divide the decimal by 2 until possible
		while (decimal > 0) {

			// Remainders after dividing the decimal by 2 will be stored
			octal[index++] = decimal % 8;

			// Move forward
			decimal = decimal / 8;

		}

		System.out.print("Decimal to Octal: ");
		// Prints the binary digits in the reverse order
		for (int i = index - 1; i >= 0; i--) {

			System.out.print(octal[i]);
		}
		System.out.println("\n");
	}

	/**
	 * This method converts hexadecimal to decimal equivalent
	 * 
	 * @param hexadecimal
	 * @return decimal equivalent
	 */
	private static int hexadecimalToDecimal(String hexadecimal) {

		// Allowed characters for a hexadecimal number
		String characters = "0123456789ABCDEFG";

		// Converting the input string to uppercase so that we can match them with the
		// characters easily
		hexadecimal = hexadecimal.toUpperCase();

		// This variable will store the decimal representation of the hexadecimal value
		int decimal = 0;

		for (int i = 0; i < hexadecimal.length(); i++) {

			// Get the character at the ith place in the input string
			char c = hexadecimal.charAt(i);

			// Get the place value of the character c
			int n = characters.indexOf(c);

			// Update the value of decimal
			decimal = 16 * decimal + n;
		}

		return decimal;
	}

	/**
	 * This method converts decimal to hexadecimal
	 * 
	 * @param decimal
	 */
	private static void decimalToHexadecimal(int decimal) {

		// Variable to store remainder
		int remainder = 0;

		// This variable will store hexadecimal equivalent
		String hexadecimal = "";

		// Characters in the Hexadecimal number system
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		while (decimal > 0) {

			// Get the remainder by dividing the number by 16
			remainder = decimal % 16;

			// Update the hexadecimal value by prepending with the allowed character at the
			// position signified by the remainder
			hexadecimal = digits[remainder] + hexadecimal;

			// Move forward
			decimal = decimal / 16;
		}

		System.out.print("Decimal to Hexadecimal: " + hexadecimal);
	}
}
