package com.sorting.algorthim;

import java.util.Arrays;

/**
 * 
 * 
 * @Description: Program to implement Insertion Sorting
 * @Input: EG-> 31 21 59 26 41 58 (Unsorted)
 * @Output: EG-> 21 26 31 41 58 59 (Ascending) 59 58 41 31 26 21 (Descending)
 * @Time Complexity: O(n^2)
 */

public class InsertionSort {

	public static void main(String[] args) {
		Integer[] array = { 170, 45, 75, 90, 802, 2, 7, 24, 66 };
		System.out.println("Before Insertion Sorting: " + Arrays.toString(array));
		sort(array);
		System.out.println("After Insertion Sorting: " + Arrays.toString(array));
	}

	/** Implementing Insertion Sorting **/
	public static Integer[] sort(Integer[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				array[j] = key;
				j--;
			}
		}
		return array;
	}
}
