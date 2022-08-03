/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.dstk.practice.java.sort;

public class App {
	public String getGreeting() {
		return "Hello World from Algorithm Sorting\n";
	}

	public static void main(String[] args) {
		System.out.println(new App().getGreeting());

		System.out.println("----------- Bubble Sorting -----------");
		int[] bArray = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10 };
		System.out.println(java.util.Arrays.toString(IntegerArraySorter.bubbleSort(bArray)));
		
		System.out.println("----------- Insertion Sorting -----------");
		int[] iArray = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10 };
		System.out.println(java.util.Arrays.toString(IntegerArraySorter.insertionSort(iArray)));
		
		System.out.println("----------- Selection Sorting -----------");
		int[] sArray = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10 };
		System.out.println(java.util.Arrays.toString(IntegerArraySorter.selectionSort(sArray)));

	}
}
