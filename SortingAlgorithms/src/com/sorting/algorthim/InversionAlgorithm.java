package com.sorting.algorthim;

import java.util.Scanner;

/**
 * Program implementing the inversion indices or inverted index
 * 
 * 
 *
 */
public class InversionAlgorithm {

	public static void main(String[] args) {
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
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (i < j) {
					if (array[i] > array[j]) {
						System.out.println("Inversion indices are: " + "("
								+ (i) + "," + (j) + ")");
						System.out.println("Indice value " + array[i] + " and "
								+ array[j]);
					}
				}
			}
		}
	}
}