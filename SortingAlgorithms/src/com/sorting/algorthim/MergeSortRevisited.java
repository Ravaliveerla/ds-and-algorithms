package com.sorting.algorthim;

import java.util.Arrays;

public class MergeSortRevisited {

	public static void main(String[] args) {
		int[] array = new int[] { 9, 21, 0, 100, 2, 9, 8, 12, 78, 1 };
		System.out.println("Array before sorting");
		printArray(array);

		mergeSort(array);

		System.out.println("Array after sorting");
		printArray(array);
	}

	public static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	private static void mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			mergeSubArrays(array, low, mid, high);
		}
	}

	private static void mergeSubArrays(int[] array, int low, int mid, int high) {

		int[] leftSubArray = new int[mid - low + 1];
		int[] rightSubArray = new int[high - mid];

		int leftIndex = low;
		for (int i = 0; i < leftSubArray.length; i++) {
			leftSubArray[i] = array[leftIndex++];
		}

		int rightIndex = mid + 1;
		for (int j = 0; j < rightSubArray.length; j++) {
			rightSubArray[j] = array[rightIndex++];
		}

		int leftArrayIter = 0;
		int rightArrayIter = 0;
		int arrayIndex = low;

		while (leftArrayIter < leftSubArray.length && rightArrayIter < rightSubArray.length) {
			if (leftSubArray[leftArrayIter] <= rightSubArray[rightArrayIter]) {
				array[arrayIndex] = leftSubArray[leftArrayIter];
				leftArrayIter++;
			} else {
				array[arrayIndex] = rightSubArray[rightArrayIter];
				rightArrayIter++;
			}
			arrayIndex++;
		}

		while (leftArrayIter < leftSubArray.length) {
			array[arrayIndex] = leftSubArray[leftArrayIter];
			leftArrayIter++;
			arrayIndex++;
		}

		while (rightArrayIter < rightSubArray.length) {
			array[arrayIndex] = rightSubArray[rightArrayIter];
			rightArrayIter++;
			arrayIndex++;
		}

	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}
