package com.sorting.algorthim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort_PositiveIntegers {

	public static void main(String[] args) {
		int[] radixArray = { 170, 45, 75, 90, 802, 2, 7, 24, 66 };
		radixsort(radixArray);
		System.out.println(Arrays.toString(radixArray));
	}

	public static void radixsort(int[] input) {
		final int RADIX = 10;
		List<Integer>[] bucket = new ArrayList[RADIX];
		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new ArrayList<Integer>();
		}

		// sort
		boolean maxLength = false;
		int tmp = 0, placement = 1;
		while (!maxLength) {
			maxLength = true;
			// split input between lists
			for (Integer i : input) {
				tmp = i / placement;
				bucket[(tmp) % RADIX].add(i);
				if (maxLength && tmp > 0) {
					maxLength = false;
				}
			}
			// empty lists into input array
			int a = 0;
			for (int b = 0; b < RADIX; b++) {
				for (Integer i : bucket[b]) {
					input[a++] = i;
				}
				bucket[b].clear();
			}
			placement *= RADIX;
		}
	}
}