package com.sorting.algorthim;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		int[] input1 = new int[] { 1, 3, 2, 2, 3, 1 };
		print(input1);
		new WiggleSort().wiggleSort(input1);
		print(input1);
	}

	public void wiggleSort(int[] numbers) {
		int median = findMedian(numbers);
		int left = 1;
		int right = numbers.length % 2 == 0 ? numbers.length - 2 : numbers.length - 1;

		int index = 0;
		while (index < numbers.length) {
			if (numbers[index] > median && !(index <= left && index % 2 == 1)) {
				swap(numbers, left, index);
				left += 2;
			} else if (numbers[index] < median && !(index >= right && index % 2 == 0)) {
				swap(numbers, right, index);
				right -= 2;
			} else {
				index++;
			}
		}
	}

	private int findMedian(int[] numbers) {
		return quickSelect(numbers, 0, numbers.length - 1, (numbers.length - 1) / 2);
	}

	private int quickSelect(int[] numbers, int left, int right, int k) {

		if (k >= 0 && k <= right - left + 1) {
			int pivotIndex = partition(numbers, left, right);

			if (pivotIndex - left == k) {
				return numbers[pivotIndex];
			} else if (pivotIndex - left > k) {
				return quickSelect(numbers, left, pivotIndex - 1, k);
			}

			return quickSelect(numbers, pivotIndex + 1, right, k - 1 - pivotIndex + left);
		}

		return Integer.MAX_VALUE;
	}

	private int partition(int[] numbers, int left, int right) {
		int i = left;
		int pivot = numbers[right];
		for (int j = i; j <= right - 1; j++) {
			if (numbers[j] <= pivot) {
				swap(numbers, i, j);
				i++;
			}
		}

		swap(numbers, i, right);

		return i;
	}

	private void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	private static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}
}
