package com.dstk.practice.java.sort;

import com.dstk.practice.java.maths.MathsUtil;

public class IntegerArraySorter {

	/**
	 * Bubble Sort
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
	 * Shell Sort
	 * 
	 * If n > 10, set first gap = sqrt(n), then iterate with 1/2 gap till gap = 1
	 * 
	 * Un-stable sort Not in place
	 * 
	 * SC = O(1)
	 * 
	 * Best TC = O(nLogn) Worst TC = O(n^2) Avg TC = ? depends on gap
	 * 
	 * 
	 * @param array
	 * @return
	 * @throws Exception
	 */
	public static int[] shellSort(int[] array) throws Exception {

		// Gap
		int gap = (int) Math.round(MathsUtil.SquareRoot2(Integer.valueOf(array.length), 0.1));

		// Iterate to divide the array item to different groups based on gap
		while (gap > 1) {

			// Iterate to perform insertion sort for each group divided by gap,
			// g is the group index
			for (int g = 0; g < gap; g++) {
				// item number of each group
				int itemNum = array.length / gap;
				if (array.length % gap > g) {
					itemNum++;
				}
				// Insertion Sort of each group, i and j are the relative item index
				for (int i = 1; i < itemNum; i++) {
					int temp = array[gap * i + g];
					int j = i - 1;
					for (; j >= 0; j--) {
						if (array[gap * j + g] > temp) {
							array[gap * (j + 1) + g] = array[gap * j + g];
							array[gap * j + g] = temp;
						} else {
							break;
						}
					}
				}
			}
			// Reduce the gap till it's 1
			gap = gap / 2;
		}

		return array;
	}

	/**
	 * Selection Sort
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

	/**
	 * Merge Sort
	 * 
	 * Stable sort
	 * 
	 * Not a sort in place
	 * 
	 * SC = O(n), since the maximum space occupation is the length of the array
	 * 
	 * Best TC = Worst TC = Avg TC = O(nLogn)
	 * 
	 * 
	 * T(1) = C； n=1时，只需要常量级的执行时间，所以表示为C。 T(n) = 2*T(n/2) + n； n>1 => T(n) =
	 * 2*T(n/2) + n = 2*(2*T(n/4) + n/2) + n = 4*T(n/4) + 2*n = 4*(2*T(n/8) + n/4) +
	 * 2*n = 8*T(n/8) + 3*n = 8*(2*T(n/16) + n/8) + 3*n = 16*T(n/16) + 4*n ...... =
	 * 2^k * T(n/2^k) + k * n ...... 当 T(n/2^k)=T(1) 时，也就是 n/2^k=1，我们得到 k=log2n =>
	 * T(n)=Cn+nlog2n => TC = O(nlogn)
	 * 
	 * @param array
	 * @return
	 */
	public static int[] mergeSort(int[] array) {
		return recursionMergeSort(array, 0, array.length - 1);
	}

	/**
	 * Recursion of splitting and sort merging
	 * 
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 * @return
	 */
	private static int[] recursionMergeSort(int[] array, int startIndex, int endIndex) {

		// End condiction
		if (startIndex >= endIndex) {
			return new int[] { array[endIndex] };
		}

		// Recursion splitting, and merge the sorted arrays
		int index = (startIndex + endIndex) / 2;
		return mergeArray(recursionMergeSort(array, startIndex, index), recursionMergeSort(array, index + 1, endIndex));
	}

	/**
	 * Used in Recursion Merge Sort Sort and Merge the 2 sub arrays
	 * 
	 * Assumption: both array A and B are sorted by ascend order
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] mergeArray(int[] a, int[] b) {

		// Compare the items one by one and put the smaller one into the new array
		int[] result = new int[a.length + b.length];
		int iA = 0;
		int iB = 0;
		int iR = 0;

		while (iA < a.length && iB < b.length) {
			// Keep stable sort, only select item in B when it smaller than item A
			if (b[iB] < a[iA]) {
				result[iR++] = b[iB++];
			} else {
				result[iR++] = a[iA++];
			}
		}

		// Put remained items of A or B into result array
		while (iA < a.length) {
			result[iR++] = a[iA++];
		}

		while (iB < b.length) {
			result[iR++] = b[iB++];
		}

		return result;
	}

	public static int[] quickSort(int[] array) {

		// Recursion of the partition of the 2 sub arrays
		recursionQuickSort(array, 0, array.length - 1);

		return array;
	}

	private static int partition(int[] array, int startIndex, int endIndex) {

		// Use last item as pivot
		int pivotValue = array[endIndex];
		// Rear of the smaller zone (Not used)
		int i = startIndex;
		// Index of 'to be handled' item
		int j = startIndex;

		// Iteration to move all items smaller than pivot to the handled zone
		for (; j < endIndex; j++) {
			// Item < pivot, then move it to the smaller zone (rear of the smaller zone -
			// array[i])
			// Swap array[i] and array[j]
			if (array[j] < pivotValue) {
				int temp = array[i];
				array[i++] = array[j];
				array[j] = temp;
			}
		}

		// Move pivot to the correct position by swapping the smaller index and endIndex
		array[endIndex] = array[i];
		array[i] = pivotValue;

		// Return pivot index
		return i;
	}

	private static void recursionQuickSort(int[] array, int startIndex, int endIndex) {

		// End condition
		if (startIndex >= endIndex) {
			return;
		}

		// Set the last item as pivot, create 2 partitions
		int pivot = partition(array, startIndex, endIndex);
		// Recursion of quick sort of each partition (smaller one, and larger one, NOT
		// including pivot !!!)
		recursionQuickSort(array, startIndex, pivot - 1);
		recursionQuickSort(array, pivot + 1, endIndex);
	}

	/**
	 * Get the Nth largest item, Use Quick Sort with descendant order
	 * 
	 * @param array
	 * @param n
	 * @return
	 */
	public static int[] getNthLargestItem(int[] array, int n) {

		// Recursion of the partition of the 2 sub arrays
		recursionQuickSortGetNthLargestItem(array, 0, array.length - 1, n);
		return array;
	}

	private static int partitionDesc(int[] array, int startIndex, int endIndex) {

		// Use last item as pivot
		int pivotValue = array[endIndex];
		// Rear of the larger zone
		int i = startIndex;
		// Index of 'to be handled' item
		int j = startIndex;

		// Iteration to move all items smaller than pivot to the handled zone
		for (; j < endIndex; j++) {
			// Item > pivot, then move it to the smaller zone (rear of the larger zone -
			// array[i])
			// Swap array[i] and array[j]
			if (array[j] > pivotValue) {
				int temp = array[i];
				array[i++] = array[j];
				array[j] = temp;
			}
		}

		// Move pivot to the correct position by swapping the smaller index and endIndex
		array[endIndex] = array[i];
		array[i] = pivotValue;

		// Return pivot index
		return i;
	}

	private static void recursionQuickSortGetNthLargestItem(int[] array, int startIndex, int endIndex, int n) {

		// End condition
		if (startIndex >= endIndex) {
			return;
		}

		// Set the last item as pivot, create 2 partitions
		int pivot = partitionDesc(array, startIndex, endIndex);

		// Recursion of quick sort of each partition (smaller one, and larger one,
		// Do NOT include pivot !!!)
		if (pivot + 1 > n) {
			recursionQuickSortGetNthLargestItem(array, startIndex, pivot - 1, n);
		} else if (pivot + 1 < n) {
			recursionQuickSortGetNthLargestItem(array, pivot + 1, endIndex, n);
		}

	}

}
