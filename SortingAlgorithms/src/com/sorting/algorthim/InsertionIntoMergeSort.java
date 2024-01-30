package com.sorting.algorthim;

import java.util.Scanner;

/**
 * Program to implement Insertion sorting in Merge sort
 * 
 *
 */
public class InsertionIntoMergeSort {

	// Declaring the arrays
	private int[] A;
	private int[] L;
	private int[] R;

	// Declaring length of the arrays
	private int length;

	/**
	 * @param aMain
	 *            [] method to initialize the arrays and invoke the sortArray()
	 *            method
	 */
	public void implementSorting(int[] aMain) {
		A = aMain;
		length = aMain.length;

		// initialize array L[]
		// this.L = new int[length];

		System.out.println(" After Sorting and size " + length);
		// invoking sortArray()
		sortArray(0, length - 1);

		// Displays the sorted array
		for (int x = 0; x < A.length; x++) {
			System.out.print(A[x] + "  ");
		}
	}

	/**
	 * Method to implement sorting of the array
	 * 
	 * @param low
	 * @param high
	 */
	private void sortArray(int low, int high) {
		// if condition to check low < high
		if (low < high) {
			// finding the mid element of the array
			int mid = low + (high - low) / 2;

			L = new int[mid + 1];
			R = new int[high + 1];

			// for loop to initialize values to L[]
			for (int x = low; x <= mid; x++) {
				L[x] = A[x];
			}

			// for loop to initialize values to R[]
			for (int y = mid + 1; y <= high; y++) {
				R[y] = A[y];
			}
			insSortArray(1, 1);
			mergeArray(low, mid, high);
		}
	}

	private void insSortArray(int x, int y) {

		if (x < L.length) {
			int key = L[x];
			int j = x - 1;
			while (j >= 0 && L[j] > key) {
				L[j + 1] = L[j];
				j = j - 1;
				L[j + 1] = key;
			}
			x++;
			insSortArray(x, y);
		}

		if (y < R.length) {
			int key = R[y];
			int z = y - 1;
			while (z >= 0 && R[z] > key) {
				R[z + 1] = R[z];
				z = z - 1;
				R[z + 1] = key;
			}
			y++;
			insSortArray(x, y);
		}
	}

	/**
	 * Method to implement merging of the sorted array
	 * 
	 * @param low
	 * @param mid
	 * @param high
	 */
	private void mergeArray(int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;

		// while loop implementing the sorting
		while (i <= mid && j <= high) {
			if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			A[k] = L[i];
			k++;
			i++;
		}

		while (j <= high) {
			A[k] = R[j];
			k++;
			j++;
		}
	}

	/**
	 * Main method to execute the sort, merge methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// declare an input array
		int[] aMain;
		// creating a reference and assigning it to an object
		InsertionIntoMergeSort iMergeSort = new InsertionIntoMergeSort();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the array A: ");
		int size = input.nextInt();
		System.out.println();

		// initialize the size of array aMain[]
		aMain = new int[size];
		System.out.println("Please enter " + aMain.length + " values: ");
		// assigning the user input values for the input array
		for (int index = 0; index < aMain.length; index++) {
			aMain[index] = input.nextInt();
		}

		// invoking the implementSorting method
		iMergeSort.implementSorting(aMain);
	}
}