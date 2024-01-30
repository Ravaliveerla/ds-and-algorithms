package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * 
 * @Description: Program to implement Insertion Sorting
 * @Input: EG-> 31 21 59 26 41 58 (Unsorted)
 * @Output: EG-> 21 26 31 41 58 59 (Ascending) 59 58 41 31 26 21 (Descending)
 * @Time Complexity: O(n^2)
 */

public class InsertionSort_Recursion {
	int[] array;

	public static void main(String[] args) {
		InsertionSort_Recursion isr = new InsertionSort_Recursion();
		isr.implementSort();
	}

	private void implementSort() {
		Scanner input = new Scanner(System.in);

		// Enter the size of the array
		System.out.print("Please enter the size of the array: ");
		int y = input.nextInt();
		array = new int[y];

		// Enter the values into the array
		System.out.print("Please enter " + array.length + " values: ");
		for (int index = 0; index < array.length; index++) {
			array[index] = input.nextInt();
		}

		/** Displaying values before insertion **/
		System.out
				.println("**************** Before Insertion Sorting ****************");
		for (int a = 0; a < array.length; a++) {
			System.out.print(" " + array[a] + " ");
		}

		System.out.println();

		sortArray_Ascending(1);

		/** Displaying the sorted array in ascending order **/
		System.out
				.println("**************** After Insertion Sorting (Ascending) ****************");
		for (int k = 0; k < array.length; k++) {
			System.out.print(" " + array[k] + " ");
		}

		System.out.println("");

		sortArray_Descending(1);

		/** Displaying the sorted array in descending order **/
		System.out
				.println("**************** After Insertion Sorting (Descending)****************");
		for (int k = 0; k < array.length; k++) {
			System.out.print(" " + array[k] + " ");
		}

	}

	/** Implementing Insertion Sorting for Ascending order **/
	private void sortArray_Ascending(int i) {
		if (i < array.length) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
				array[j + 1] = key;
			}
			i++;
			sortArray_Ascending(i);
		}
	}

	/** Implementing Insertion Sorting for Ascending order **/
	private void sortArray_Descending(int i) {
		if (i < array.length) {
			int key = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] < key) {
				array[j + 1] = array[j];
				j = j - 1;
				array[j + 1] = key;
			}
			i++;
			sortArray_Descending(i);
		}
	}
}
