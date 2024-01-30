package com.sorting.problems;

import java.util.Scanner;

public class SearchSumOfTwoNums {

	int[] array;

	private String searchTheSum() {

		Scanner scn2 = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = scn2.nextInt();
		System.out.println("Enter " + n + " elements");

		array = new int[n];
		for (int size = 0; size < n; size++) {
			array[size] = scn2.nextInt();
		}
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the sum search number: ");
		int searchNumber = scn.nextInt();
		/**
		 * Implementing Searching
		 */
		for (int i = 0; i < n-1; i++) {
			int j = i + 1;
			while (j < n) {
				if(array[i] + array[j] == searchNumber){
				return "Found";
				}
				j++;
			}
		}
		return "Not Found";
	}
 
	public static void main(String[] args) {

		SearchSumOfTwoNums search = new SearchSumOfTwoNums();
		String result = search.searchTheSum();
		System.out.println("The required element is " +result);
	}
}
