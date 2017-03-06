package symboltable;

import datastructures.ArrayQueue;

public class BinarySearchTree<K extends Comparable<K>, V> {

	private Node root;

	public Node getRoot() {
		return this.root;
	}

	protected class Node {
		K key;
		V value;
		Node left;
		Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node n) {
		if (n == null)
			return;
		preOrder(n.left);
		preOrder(n.right);
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node n) {
		if (n != null) {
			inOrder(n.left);
			inOrder(n.right);
		}
	}

	public void breadthFirstSearch() {
		ArrayQueue<Node> q = new ArrayQueue<>();
		q.enqueue(root);
		while (!q.isEmpty()) {
			Node front = q.front();
			if (front.left != null)
				q.enqueue(front.left);
			if (front.right != null)
				q.enqueue(front.right);
			q.dequeue();
		}
	}

	public V get(K key) {
		Node z = root;
		while (z != null) {
			int c = z.key.compareTo(key);
			if (c > 0)
				z = z.left;
			else if (c < 0)
				z = z.right;
			else
				return z.value;
		}
		return null;
	}

	public boolean contains(K key) {
		return get(key) == null;
	}

	public void insert(K key, V value) {
		Node temp = new Node(key, value);
		if (root == null) {
			root = temp;
			return;
		}
		Node child = root, parent = null;
		while (child != null) {
			parent = child;
			int c = child.key.compareTo(key);
			if (c > 0)
				child = child.left;
			else if (c < 0)
				child = child.right;
			else {
				child.value = value;
				return;
			}
		}
		if (parent.key.compareTo(key) > 0)
			parent.left = temp;
		else
			parent.right = temp;
	}

	public boolean isEmpty() {
		return root == null;
	}

}
