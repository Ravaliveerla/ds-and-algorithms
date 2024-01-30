package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * 
 * @Description: Program to implement Selection Sorting
 * @Input: EG-> 31 21 59 26 41 58 (Unsorted)
 * @Output: EG-> 31 21 26 41 58 59 (Ascending)
 * @Time Complexity: O(n^2)
 */
public class SelectionSort {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		// Enter the size of the array
		System.out.print("Please enter the size of the array: ");
		int y = input.nextInt();
		int[] array = new int[y];

		// Enter the values into the array
		System.out.print("Please enter " + array.length + " values: ");
		for (int index = 0; index < array.length; index++) {
			array[index] = input.nextInt();
		}

		/** Displaying values before Selection **/
		System.out
				.println("**************** Before Selection Sorting ****************");
		for (int a = 0; a < array.length; a++) {
			System.out.print(" " + array[a] + " ");
		}

		/** Implementing Selection Sorting for Ascending order **/
		for (int i = 0; i < array.length - 1; i++) {
			int x = i + 1;
			while (x <= array.length - 1) {
				if (array[i] > array[x]) {
					int temp = array[x];
					array[x] = array[i];
					array[i] = temp;
				}
				x++;
			}
		}

		System.out.println("");

		/** Displaying the sorted array in ascending order **/
		System.out
				.println("**************** After Selection Sorting (Ascending) ****************");
		for (int k = 0; k < array.length; k++) {
			System.out.print(" " + array[k] + " ");
		}
	}
}