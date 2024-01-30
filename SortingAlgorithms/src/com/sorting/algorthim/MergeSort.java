package com.sorting.algorthim;

import java.util.Arrays;

/**
 * 
 *  Desc: Program to implement Merge Sort
 */

public class MergeSort {

	private int[] LR;

	public static void main(String[] args) {

		int[] aMain = new int[] { 9, 21, 0, 100, 2, 9, 8, 12, 78, 1 };
		MergeSort mergeSort = new MergeSort();
		System.out.println("Array before sorting: " + Arrays.toString(aMain));
		mergeSort.implementSorting(aMain);
	}

	public void implementSorting(int[] aMain) {
		int length = aMain.length;
		this.LR = new int[length];

		sortArray(aMain, 0, length - 1);

		System.out.println("Array after sorting: " + Arrays.toString(aMain));
	}

	/**
	 * Method to implement sorting of the array
	 * 
	 * @param low
	 * @param high
	 */
	private void sortArray(int[] arr, int low, int high) {
		// if condition to check low < high
		if (low < high) {
			// finding the mid element of the array
			int mid = low + (high - low) / 2;
			// invoking sortArray() passing low,high
			sortArray(arr, low, mid);
			// invoking sortArray() passing mid+1,high
			sortArray(arr, mid + 1, high);
			// invoking mergeArray()
			mergeArray(arr, low, mid, high);
		}
	}

	/**
	 * Method to implement merging of the sorted array
	 * 
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void mergeArray(int[] arr, int low, int mid, int high) {

		// for loop to initialize values to LR[]
		for (int i = low; i <= high; i++) {
			LR[i] = arr[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;

		// while loop implementing the sorting
		while (i <= mid && j <= high) {
			if (LR[i] <= LR[j]) {
				arr[k] = LR[i];
				i++;
			} else {
				arr[k] = LR[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k] = LR[i];
			k++;
			i++;
		}
	}
}