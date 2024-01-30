package com.sorting.algorthim;

public class QuickSelect2 {

	public static void main(String[] args) {
		System.out.println(new QuickSelect2().kthSmallest(new int[] { 1, -1, 9, 2, 3, 7 }, 2));
	}

	public int kthSmallest(int[] arr, int K) {
		int len = arr.length, l = 0, r = len - 1;
		while (l <= r) {
			int mid = partition(arr, l, r);
			if (mid == K)
				return arr[K];
			if (mid < K) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
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

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}