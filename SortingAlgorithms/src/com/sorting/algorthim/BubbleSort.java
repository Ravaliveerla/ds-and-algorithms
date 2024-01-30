package com.sorting.algorthim;

import java.util.Scanner;

public class BubbleSort {
	public static Scanner scn;

	public static void main(String[] args) {
		try {
			scn = new Scanner(System.in);
			System.out.println("Enter the size of the array");
			int size = scn.nextInt();
			int[] arr = new int[size];
			insertElements(arr);
			System.out.println("Elements before sorting");
			displayArray(arr);
			doSorting(arr);
			System.out.println("Elements after sorting");
			displayArray(arr);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void insertElements(int[] num) {
		System.out.println("Enter " + num.length + " elements for sorting");
		for (int i = 0; i < num.length; i++) {
			num[i] = scn.nextInt();
		}
	}

	public static void displayArray(int[] num) {
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i] + " ");
		}
		System.out.println();
	}

	// Bubble Sort Method for Descending Order
	public static void doSorting(int[] num) {
		int j;
		boolean flag = true;
		int temp;
		while (flag) {
			flag = false;
			for (j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) {
					temp = num[j];
					num[j] = num[j + 1];
					num[j + 1] = temp;
					flag = true;
				}
			}
		}
	}
}
