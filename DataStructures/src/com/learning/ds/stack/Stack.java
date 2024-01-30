package com.learning.ds.stack;

public class Stack {
	private int maxSize;
	private long[] stackArray;
	private int top;

	public Stack(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}

	public void push(long j) {
		stackArray[++top] = j;
	}

	public long pop() {
		return stackArray[top--];
	}

	public long peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		System.out.println(stack.isFull());
		while (!stack.isEmpty()) {
			long value = stack.pop();
			System.out.print(value + " ");
		}
		System.out.println();
		System.out.println(stack.isEmpty());
	}
}