/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.dstk.practice.java.array;

import java.util.Arrays;

public class App {
	public String getGreeting() {
		return "Hello World!";
	}

	public static void main(String[] args) {
		System.out.println(new App().getGreeting());

		// Integer array
		int[] anArray = new int[10];

		anArray[0] = 100; // initialize first element
		anArray[1] = 200; // initialize second element
		anArray[2] = 300; // and so forth

		System.out.println("Element 1 at index 0: " + anArray[0]);
		System.out.println("Element 2 at index 1: " + anArray[1]);
		System.out.println("Element 3 at index 2: " + anArray[2]);
		System.out.println("\n");

		// Multidimensional array
		String[][] names = { { "Mr. ", "Mrs. ", "Ms. " }, { "Smith", "Jones" } };

		// Mr. Smith
		System.out.println(names[0][0] + names[1][0]);
		// Ms. Jones
		System.out.println(names[0][2] + names[1][1]);
		System.out.println("\n");

		// String Array
		String[] copyFrom = { "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado", "Doppio", "Espresso",
				"Frappucino", "Freddo", "Lungo", "Macchiato", "Marocchino", "Ristretto" };

		// System method
		// arraycopy
//     		String[] copyTo = new String[7];
//     		System.arraycopy(copyFrom, 2, copyTo, 0, 7);

		// java.util.Arrays method
		// copyOfRange
		String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
		
		System.out.println("Array is: ");
		for (String coffee : copyTo) {
			System.out.print(coffee + " ");
		}
		System.out.println("\n");

		// Stream
		System.out.println("Stream is: ");
		java.util.Arrays.stream(copyTo).map(coffee -> coffee + " ").forEach(System.out::print);
		System.out.println("\n");

		// Sequentially Sort the array first
		Arrays.sort(copyFrom);

		// binarySearch
		int indexOfLungo = java.util.Arrays.binarySearch(copyFrom, "Lungo");
		System.out.println("index of Lungo is: " + indexOfLungo);
		System.out.println("\n");

		// Compare byte arrays
		byte[] byteArr1 = { 10, 20, 15, 22, 35 };
		byte[] byteArr2 = { 10, 20, 15, 22, 35 };
		System.out.println("Array1 and Array2 is identical? " + Arrays.equals(byteArr1, byteArr2));
		System.out.println("\n");
		byteArr2[1] = 30;
		System.out.println("1st byte in array 2 is: " + byteArr2[1]);
		System.out.println("\n");

		// Concurrently sort the byte array
		Arrays.parallelSort(byteArr2);
		System.out.println("2nd byte array is: " + Arrays.toString(byteArr2));
		System.out.println("\n");

		// Compare String arrays
		String[] strArr1 = { "Affogato", "Americano", "Cappuccino" };
		String[] strArr2 = { "Affogato", "Americano", "Cappuccino" };
		System.out.println("Array1 and Array2 is identical? " + Arrays.equals(strArr1, strArr2));
		// Should be false, since strArr1 and strArr2 are not primitive type
		System.out.println("Array1 addr and Array2 addr is identical? " + (strArr1 == strArr2));
		System.out.println("\n");
		strArr2[1] = "Moka";
		System.out.println("1st string in array 2 is: " + strArr2[1]);
		System.out.println("\n");

		// Compare char arrays
		char[] charArr1 = { 'a', 'b', 'c' };
		char[] charArr2 = { 'a', 'b', 'c' };
		System.out.println("char Array1 and Array2 is identicla? " + Arrays.equals(charArr1, charArr2));
		// Should be false, since charArr1 and charArr2 are not primitive type
		System.out.println("char Array1 addr and Array2 addr is identical? " + (charArr1 == charArr2));
		System.out.println("\n");
		charArr2[1] = 'm';
		System.out.println("1st char in array 2 is: " + charArr2[1]);
		System.out.println("\n");

		// Fill entire array
		String[] strArrToFill = { "Affogato", "Americano", "Cappuccino" };
		// Fill "Latte" to every position
		Arrays.fill(strArrToFill, "Latte");
		System.out.println("Filled Array is: " + Arrays.toString(strArrToFill));
		System.out.println("\n");

		// Append "Latte" to the rear
		String[] strArrToFillIndex = { "Affogato", "Americano", "Cappuccino" };
		// 2nd arg is from Index, 3rd arg is the end position (Index+1)
		Arrays.fill(strArrToFillIndex, 1, 3, "Latte");
		System.out.println("Appended Array is: " + Arrays.toString(strArrToFillIndex));
		System.out.println("\n");
	}
}