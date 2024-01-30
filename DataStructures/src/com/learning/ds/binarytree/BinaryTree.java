package com.learning.ds.binarytree;

/**
 * Snippet for Binary Tree remove method
 * 
 * 
 *
 */

public class BinaryTree {

	public Node root;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
		}
	}

	private void deleteNode() {
		deleteNode(root);
	}

	/**
	 * Method to delete the node from a binary tree
	 * 
	 * @throws IllegalArgumentException
	 * @param node
	 */
	private void deleteNode(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Tree is empty!!");
		}

		while (node.left != null || node.right != null) {
			if (node.right != null) {
				node = node.right;
			} else {
				node = node.left;
			}
		}

		node = null;
	}
}
