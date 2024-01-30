package com.learning.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * JAVA Program to traverse a graph using Depth First Search (DFS) and Breadth
 * First Search (BFS)<br>
 * DFS: Time Complexity O (V + E)<br>
 * BFS: Time Complexity O (V + E)<br>
 * 
 * 
 *
 */
public class GraphTraversal {

	@SuppressWarnings("resource")
	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);
		Node<String> source = getSampleGraph2();
		System.out.println("Choose an option: ");
		System.out.println("1. DFS by Recursion");
		System.out.println("2. DFS by Iterative (Stack)");
		System.out.println("3. BFS by Iterative (Queue)");
		System.out.println("4. BFS by Iterative (LevelList)");
		int option = scn.nextInt();
		switch (option) {
		case 1:
			System.out
					.println("*******************DFS by Recursion*******************");
			traverseDFSByRecursion(source);
			break;
		case 2:
			System.out
					.println("*******************DFS by Iterative (Stack)*******************");
			traverseDFSByIterative(source);
			break;
		case 3:
			System.out
					.println("*******************BFS by Iterative (Queue)*******************");
			traversalBFSByQueue(source);
			break;
		case 4:
			System.out
					.println("*******************BFS by Iterative (LevelList)*******************");
			traversalBFSByLevelList(source);
			break;
		}
	}

	public static void traverseDFSByRecursion(Node<String> currentNode) {
		if (null == currentNode) {
			return;
		}
		visitNode(currentNode);
		currentNode.visited = true;

		for (Node<String> neighbor : currentNode.neighbors) {
			if (!neighbor.visited) {
				traverseDFSByRecursion(neighbor);
			}
		}
	}

	public static void traversalBFSByQueue(Node<String> source) {
		if (null == source) {
			return;
		}
		Queue<Node<String>> queue = new LinkedList<Node<String>>();
		queue.add(source);
		visitNode(source);
		source.visited = true;
		while (!queue.isEmpty()) {
			Node<String> currentNode = queue.poll();
			for (Node<String> neighbor : currentNode.neighbors) {
				if (!neighbor.visited) {
					visitNode(neighbor);
					neighbor.visited = true;
					queue.add(neighbor);
				}
			}
		}
	}

	public static void traverseDFSByIterative(Node<String> source) {
		if (null == source) {
			return;
		}
		Stack<Node<String>> stack = new Stack<Node<String>>();
		stack.push(source);
		while (!stack.isEmpty()) {
			Node<String> currentNode = stack.pop();
			visitNode(currentNode);
			currentNode.visited = true;
			// for (int i = currentNode.neighbors.size() - 1; i >= 0; i--) {
			for (int i = 0; i < currentNode.neighbors.size(); i++) {
				Node<String> neighbor = currentNode.neighbors.get(i);
				if (!neighbor.visited) {
					stack.push(neighbor);
				}
			}
		}
	}

	public static void traversalBFSByLevelList(Node<String> source) {
		if (null == source) {
			return;
		}
		Set<Node<String>> frontier = new HashSet<Node<String>>();
		HashMap<Node<String>, Integer> level = new HashMap<Node<String>, Integer>();
		int moves = 0;
		frontier.add(source);
		visitNode(source);
		level.put(source, moves);
		while (!frontier.isEmpty()) {
			Set<Node<String>> next = new HashSet<Node<String>>();
			for (Node<String> parent : frontier) {
				for (Node<String> neighbor : parent.neighbors) {
					if (!level.containsKey(neighbor)) {
						visitNode(neighbor);
						level.put(neighbor, moves);
						next.add(neighbor);
					}
				}
			}
			moves++;
			frontier = next;
		}
	}

	public static void visitNode(Node<String> node) {
		if (!node.visited)
			System.out.printf(" %s ", node.data);
	}

	public static Node<String> getSampleGraph2() {
		Node<String> A = new Node<String>("A");
		Node<String> B = new Node<String>("B");
		Node<String> C = new Node<String>("C");
		Node<String> D = new Node<String>("D");
		Node<String> E = new Node<String>("E");
		Node<String> F = new Node<String>("F");

		A.neighbors.add(B);
		A.neighbors.add(C);

		B.neighbors.add(A);
		B.neighbors.add(D);
		B.neighbors.add(E);

		C.neighbors.add(A);
		C.neighbors.add(F);

		D.neighbors.add(B);

		E.neighbors.add(B);
		E.neighbors.add(F);

		F.neighbors.add(C);
		F.neighbors.add(E);

		return A;
	}

	public static Node<String> getSampleGraph() {
		Node<String> S = new Node<String>("S");
		Node<String> A = new Node<String>("A");
		Node<String> C = new Node<String>("C");
		Node<String> B = new Node<String>("B");
		Node<String> D = new Node<String>("D");
		Node<String> E = new Node<String>("E");
		Node<String> F = new Node<String>("F");
		Node<String> V = new Node<String>("V");

		S.neighbors.add(A);
		S.neighbors.add(C);

		A.neighbors.add(S);
		A.neighbors.add(B);

		B.neighbors.add(A);

		C.neighbors.add(S);
		C.neighbors.add(D);
		C.neighbors.add(E);

		D.neighbors.add(C);
		D.neighbors.add(E);
		D.neighbors.add(F);

		E.neighbors.add(C);
		E.neighbors.add(D);
		E.neighbors.add(F);
		E.neighbors.add(V);

		F.neighbors.add(D);
		F.neighbors.add(E);
		F.neighbors.add(V);

		V.neighbors.add(E);
		V.neighbors.add(F);
		return S;
	}
}

class Node<T> {

	T data;
	List<Node<T>> neighbors = null;
	boolean visited = false;

	Node(T value) {
		data = value;
		neighbors = new ArrayList<Node<T>>();
	}

	@Override
	public int hashCode() {
		int hash = this.data.hashCode() + (this.visited ? 1 : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Node<?> other = (Node<?>) obj;
		if (this.data != other.data
				&& (this.data == null || !this.data.equals(other.data))) {
			return false;
		}
		return true;
	}

}