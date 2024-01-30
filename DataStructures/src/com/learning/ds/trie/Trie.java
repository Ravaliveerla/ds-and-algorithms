package com.learning.ds.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private TrieNode root;

	public Trie() {
		this.root = new TrieNode(null);
	}

	static class TrieNode {
		@Override
		public String toString() {
			return "[character=" + character + ", childrenTrieNodes=" + childrenTrieNodes + ", isEnd=" + isEnd + "]";
		}

		Character character;
		Map<Character, TrieNode> childrenTrieNodes;
		boolean isEnd;

		public TrieNode(Character character) {
			this(character, false);
		}

		public TrieNode(Character character, boolean isEnd) {
			this.character = character;
			this.isEnd = isEnd;
			this.childrenTrieNodes = new HashMap<Character, Trie.TrieNode>();
		}
	}

	private void insert(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			Character letter = word.charAt(i);
			Map<Character, TrieNode> childrenTrieNodes = curr.childrenTrieNodes;

			TrieNode child = childrenTrieNodes.get(letter);

			if (child == null) {
				child = new TrieNode(letter);
				childrenTrieNodes.put(letter, child);
			}

			if (i == word.length() - 1) {
				child.isEnd = true;
			}
			curr = child;
		}
	}

	private boolean search(String word) {
		TrieNode curr = root;

		for (int i = 0; i < word.length(); i++) {
			Character letter = word.charAt(i);
			TrieNode child = curr.childrenTrieNodes.get(letter);

			if (child == null) {
				return false;
			}

			if (i == word.length() - 1 && !child.isEnd) {
				return false;
			}

			curr = child;
		}

		return true;
	}

	private boolean delete(String word) {
		return delete(word, root, 0);
	}

	private boolean delete(String word, TrieNode node, int index) {

		Character letter = word.charAt(index);
		TrieNode child = node.childrenTrieNodes.get(letter);

		if (child == null) {
			return false;
		}

		if (index == word.length() - 1) {
			if (!child.isEnd) {
				return false;
			} else {
				child.isEnd = false;
				return child.childrenTrieNodes.size() == 0;
			}
		}

		boolean shouldDelete = delete(word, child, index + 1);

		if (shouldDelete) {
			node.childrenTrieNodes.remove(letter);
			shouldDelete = node.childrenTrieNodes.size() == 0;
		}
		return shouldDelete;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		System.out.println(trie.search("abc"));
		trie.insert("abcd");
		System.out.println(trie.delete("abc"));
		System.out.println("abc: "+trie.search("abc"));
		System.out.println("abcd: "+trie.search("abcd"));

		trie.insert("hello world");
		System.out.println(trie.search("hello world"));
	}
}