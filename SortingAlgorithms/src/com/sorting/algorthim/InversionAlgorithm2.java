package com.sorting.algorthim;

import java.util.Scanner;

/**
 * Program implementing the inversion algorithm
 * 
 * 
 *
 */
public class InversionAlgorithm2 {

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
		this.A = aMain;
		length = aMain.length;

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
			// invoking sortArray() passing low,high
			sortArray(low, mid);
			// invoking sortArray() passing mid+1,high
			sortArray(mid + 1, high);
			// invoking mergeArray()
			mergeArray(low, mid, high);
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

		System.out.println(" " + low + " " + mid + " " + high);
		int n1 = mid - low + 1; // 1
		int n2 = high - mid; // 1

		this.L = new int[n1 + 1]; // 2
		this.R = new int[n2 + 1]; // 2

		// for loop to initialize values to L[]
		for (int x = low; x < n1; x++) {
			L[x] = A[low];
		}

		// for loop to initialize values to R[]
		for (int y = low; y <= n2; y++) {
			R[y] = A[mid + y];
		}

		int i = low;
		int j = low;
		int y = 1;
		int loopCounter = 0;

		for (int k = low; k < high; k++) {
			{
				if (i < y) {
					if (L[i] <= R[j]) {
						A[k] = L[i];
						System.out.println("(" + L[i] + "," + R[j] + ")");
						i++;
					} else {
						A[k] = R[j];
						System.out.println("(" + L[i] + "," + R[j] + ")");
						j++;
						loopCounter = loopCounter + (n1 - i);
					}
				}
			}
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
		InversionAlgorithm2 invsAlg = new InversionAlgorithm2();
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
		invsAlg.implementSorting(aMain);
	}
}