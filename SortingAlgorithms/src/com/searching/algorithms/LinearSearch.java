package com.searching.algorithms;

public class LinearSearch {
	public static int doLinearSearch(int[] arr, int key) {

		int size = arr.length;
		for (int i = 0; i < size; i++) {
			if (arr[i] == key) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String a[]) {
		int[] arr1 = { 23, 45, 21, 55, 234, 1, 34, 90 };
		int searchKey = 34;
		int result1 = doLinearSearch(arr1, searchKey);
		if (result1 != -1) {
			System.out.println("Key " + searchKey + " found at index: "
					+ result1 + " in array #1");
		} else {
			System.out.println("Element not found in array #1");
		}
		int[] arr2 = { 123, 445, 421, 595, 2134, 41, 304, 190 };
		searchKey = 421;
		int result2 = doLinearSearch(arr2, searchKey);
		if (result2 != -1) {
			System.out.println("Key " + searchKey + " found at index: "
					+ result2 + " in array #2");
		} else {
			System.out.println("Element not found in array #2");
		}
	}
}
