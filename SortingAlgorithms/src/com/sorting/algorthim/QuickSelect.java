package com.sorting.algorthim;

public class QuickSelect {

	public static void main(String[] args) {
		System.out.println(new QuickSelect().kthSmallest(new int[] {1, 3, 2, 2, 3, 1}, 3));
	}

	public int kthSmallest(int[] arr, int k) {
		return kthSmallest(arr, 0, arr.length - 1, k - 1);
	}

	public int kthSmallest(int[] arr, int left, int right, int k) {
		if (k >= 0 && k <= right - left + 1) {
			int pos = partition(arr, left, right);
			if (pos - left == k) {
				return arr[pos];
			}
			if (pos - left > k) {
				return kthSmallest(arr, left, pos - 1, k);
			}
			return kthSmallest(arr, pos + 1, right, k - pos + left - 1);
		}
		return 0;
	}

	public int partition(int[] arr, int left, int right) {
		int pivot = arr[right], i = left;
		for (int j = left; j <= right - 1; j++) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, right);
		return i;
	}

	public void swap(int[] arr, int n1, int n2) {
		int temp = arr[n2];
		arr[n2] = arr[n1];
		arr[n1] = temp;
	}
}