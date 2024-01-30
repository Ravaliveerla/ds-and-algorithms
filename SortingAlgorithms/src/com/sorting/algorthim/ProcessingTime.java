package com.sorting.algorthim;

public class ProcessingTime {

	public static void main(String[] args) {

		System.out.println("-------------");

		int intMin = Integer.MIN_VALUE;
		int intMax = Integer.MAX_VALUE;

		long startTime2 = System.currentTimeMillis();
		int y = intMin;
		while (y < intMax) {
			y++;
		}
		System.out.println(y);
		long endTime2 = System.currentTimeMillis();
		System.out.println("Elapsed time2: " + (endTime2 - startTime2)
				+ " msecs");
		long longMin = -9223372036854775808L;
		long longMax = 9223372036854775807L;

		long startTime = System.currentTimeMillis();
		long x = longMin;
		while (x < longMax) {
			x++;
		}
		System.out.println(x);
		long endTime = System.currentTimeMillis();
		System.out.println("Elapsed time: " + (endTime - startTime) + " msecs");


	}

}
