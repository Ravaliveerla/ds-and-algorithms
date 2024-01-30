package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * @Description: Program to find a specific value from an array of values
 */

public class InvariantLoop {

	int[] array = new int[4];
	int x;
	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		InvariantLoop ivp = new InvariantLoop();
		ivp.controlSearch();
	}

	/**
	 * This method fills the array with values and calls the method
	 * searchvalue(int x) by passing a value 'x'
	 * 
	 * @return the index of the found number else return null
	 */
	public int controlSearch() {

		// Enter the values into the array
		System.out.print("Please enter " + array.length + " values: ");
		for (int index = 0; index < array.length; index++) {
			array[index] = input.nextInt();
		}

		// Enter a number that is to be searched
		System.out.print("Enter a number ");
		x = input.nextInt();

		return searchValue(x);
	}

	/**
	 * This method searches the desired number in the array
	 * 
	 * @param x
	 * @return i
	 */
	public int searchValue(int x) {

		// For loop implemeting the search and returning the values (i or 0)
		for (int i = 0; i < array.length; i++) {
			if (x == array[i]) {
				System.out.println("value of i is " + i);
				return i;
			}
		}
		return 0;
	}
}
