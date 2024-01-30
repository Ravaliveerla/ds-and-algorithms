package com.sorting.algorthim;

import java.util.Scanner;

/**
 * 
 * 
 * @Description: Program to implement binary addition
 * 
 */
public class BinaryAddition_Matrix {

	// decalre and initialize variables
	int x = 0;
	int[] array_A = new int[x];
	int[] array_B = new int[x];

	public static void main(String[] args) {
		// invoking the method controlArrays()
		new BinaryAddition_Matrix().controlArrays();
	}

	/**
	 * @param arrays
	 *            size, numbers
	 */
	public void controlArrays() {
		Scanner input = new Scanner(System.in);

		// Passing array size
		System.out.println("Enter size of array: ");
		x = input.nextInt();

		// Passing the value for array_A
		System.out.println("Enter a number_1");
		int a = input.nextInt();

		array_A = new int[x];
		// invoking the method convertToBinary
		array_A = convertToBinary(a, array_A);

		System.out.println(" ");

		// Passing the value for array_B
		System.out.println("Enter another number_ 2");
		int b = input.nextInt();

		array_B = new int[x];
		array_B = convertToBinary(b, array_B);

		System.out.println(" ");

		// invoking addArray method passing arrays A,B
		addArray(array_A, array_B);
	}

	/**
	 * 
	 * @desc: method converts decimal to binary
	 * @param array
	 *            and the decimal number
	 * @return array of binary values
	 */
	public int[] convertToBinary(int arrayElement, int[] array) {
		int remainder;

		int i;
		if (arrayElement == 0) {
			array[0] = 0;
		} else {

			// for loop to convert decimal to binary
			for (i = 0; arrayElement >= 2; i++) {
				remainder = arrayElement % 2;
				arrayElement = arrayElement / 2;
				array[i] = remainder;
			}
			if (arrayElement == 1) {
				array[i] = 1;
			}
		}

		// for loop to display the converted binary value
		for (int z = array.length - 1; z >= 0; z--) {
			System.out.print(array[z]);
		}
		return array;
	}

	/**
	 * 
	 * @param Array_A
	 *            (binary values)
	 * @param Array_B
	 *            (binary values)
	 */
	private void addArray(int[] tempArray_A2, int[] tempArray_B2) {
		int[] array_C = new int[x + 1];
		int carry = 0;

		// for loop to perform binary addition
		for (int z1 = 0; z1 < x; z1++) {
			array_C[z1] = (array_A[z1] + array_B[z1] + carry) % 2;
			carry = (array_A[z1] + array_B[z1] + carry) / 2;
		}
		array_C[x] = carry;
		System.out.println(" The value of the array C is ");

		// for loop to display the final value of A + B
		for (int c = array_C.length - 1; c >= 0; c--) {
			System.out.print(array_C[c]);
		}
	}
}
