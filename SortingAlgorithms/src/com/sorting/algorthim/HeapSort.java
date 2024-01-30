package com.sorting.algorthim;

import java.util.Arrays;
/**
 * 
 * @Description: Program to implement Heap Sorting
 * @Input: EG-> 31 21 59 26 41 58 (Unsorted)
 * @Output: EG-> 21 26 31 41 58 59 (Ascending) 59 58 41 31 26 21 (Descending)
 * @Time Complexity: O(n^2)
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {2, 8, 5, 3, 9, 1};
        System.out.println("Before Heap Sorting: " + Arrays.toString(array));
        sort(array);
        System.out.println("After Heap Sorting: " + Arrays.toString(array));
    }

    /* Sort Function */
    public static void sort(int arr[]) {

        int n = arr.length - 1;
        heapify(arr, n);

        for (int i = n; i > 0; i--) {
            swap(arr, 0, i);
            n--;
            maxHeap(arr, n, 0);
        }
    }

    /* Function to build a heap */
    public static void heapify(int arr[], int size) {
        for (int i = size / 2; i >= 0; i--) {
            maxHeap(arr, size, i);
        }
    }

    /* Function to swap largest element in heap */
    public static void maxHeap(int arr[], int currSize, int largeIndex) {

        int left = 2 * largeIndex;
        int right = 2 * largeIndex + 1;
        int maxIndex = largeIndex;

        if (left <= currSize && arr[left] > arr[largeIndex])
            maxIndex = left;
        if (right <= currSize && arr[right] > arr[maxIndex])
            maxIndex = right;

        if (maxIndex != largeIndex) {
            swap(arr, largeIndex, maxIndex);
            maxHeap(arr, currSize, maxIndex);
        }
    }

    /* Function to swap two numbers in an array */
    public static void swap(int arrA[], int i, int j) {
        int tmp = arrA[i];
        arrA[i] = arrA[j];
        arrA[j] = tmp;
    }
}
