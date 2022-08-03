package com.dstk.practice.java.sort;

public class IntegerArraySorter {

	/**
	 * Bubble sort
	 * 
	 * Stable sorting
	 * 
	 * Sort in place
	 * 
	 * SC = Space complexity = O(1)
	 * 
	 * TC = Time complexity
	 * 
	 * Best TC = O(n)
	 * 
	 * Worst TC = O(n*n)
	 * 
	 * Avg TC = O(n*n), based on below calculation 'degree of order': worst =
	 * n(n-1)/2, best = 0 the avg replacing times = (worst + best)/2 = n(n-1)/4
	 * besides: comparing times much more than replacing times, and the maximum TC =
	 * n*n => Avg TC = O(n*n)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] bubbleSort(int[] array) {

		for (int n = array.length; n >= 2; n--) {

			boolean isSwapped = false;

			for (int i = 0; i < n - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					isSwapped = true;
				}
			}

			if (!isSwapped) {
				break;
			}

		}

		return array;
	}

	/**
	 * Insertion Sort
	 * 
	 * Stable sorting
	 * 
	 * Sort in place
	 * 
	 * SC = O(1)
	 * 
	 * Best TC = O(n)
	 * 
	 * Worst TC = O(n*n)
	 * 
	 * Avg TC = O(n*n)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] insertionSort(int[] array) {

		for (int i = 1; i < array.length; i++) {

			int temp = array[i];
			int j = i - 1;
			
			for (; j >= 0; j--) {
				if (array[j] > temp) {
					array[j + 1] = array[j];
//					array[j] = temp; // Do NOT need this, since it will be done in else loop
				} else {
					break;
				}
			}

			// Insert the value to the correct position
			// Put here to ensure array[0] works fine
			array[j + 1] = temp;

		}

		return array;
	}

	/**
	 * Selection Sorting
	 * 
	 * Unstable sorting, since the order of items with same value might change
	 * during the selection and swapping
	 * 
	 * Sort in place
	 * 
	 * SC = O(1)
	 * 
	 * Best TC = Worst TC = Avg TC = O(n*n)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] selectionSort(int[] array) {

		for (int i = 0; i < array.length; i++) {

			int index = i;
			int temp = array[index];

			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < temp) {
					temp = array[j];
					index = j;
				}
			}

			if (index != i) {
				temp = array[i];
				array[i] = array[index];
				array[index] = temp;
			}
		}

		return array;
	}

}
