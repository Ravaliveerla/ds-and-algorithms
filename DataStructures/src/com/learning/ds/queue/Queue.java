package com.learning.ds.queue;

public class Queue {

	public static Node front;
	public static Node end;
	public static int size = 0;

	public static int size() {

		if (front == null || end == null) {
			System.out.println("Queue is empty!!");
		}
		return size;
	}

	public static void enqueue(int data) {
		Node queue = new Node(data, null);

		if (front == null) {
			front = queue;
			end = front;
		} else {
			queue.setLink(end);
			end = queue;
		}
		size++;
	}

	public static int dequeue() {
		if (size == 0) {
			throw new IllegalArgumentException("Queue is empty!!");
		}
		Node next = end;
		while (next.link != front) {
			next = next.link;
		}
		next.link = null;
		Node ret = front;
		front = next;
		size--;
		return ret.data;
	}

	public static void display() {
		Node next = new Node();
		next = end;
		while (next != null) {
			System.out.print(next.getData() + " ");
			next = next.getLink();
		}
		System.out.println();
	}

	public static void main(String args[]) {
		System.out.println("Size: "+size());
		enqueue(10);
		display();
		System.out.println("Size: "+size());
		enqueue(100);
		display();
		System.out.println(dequeue());
		System.out.println("Size: "+size());
		enqueue(40);
		display();
		enqueue(123);
		display();
	}
}