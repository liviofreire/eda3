package br.ufc.crateus.eda.st;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeST<K extends Comparable<K>, V> implements OrderedST<K, V> {
	
	protected Node root;
	
	protected class Node {
		K key;
		V value;
		Node left;
		Node right;
		int count;
		
		public Node(K key, V value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}	
	}

	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
	}
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new Node(key, value, 1);
		int cmp = key.compareTo(r.key);
		if (cmp < 0)  r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}
	
	private int size(Node r) {
		return (r != null)? r.count : 0;
	}

	@Override
	public V get(K key) {
		Node r = root;
		while (r != null) {
			int cmp = key.compareTo(r.key);
			if (cmp < 0) r = r.left;
			else if (cmp > 0) r = r.right;
			else return r.value;
		}
		return null;
	}

	@Override	
	public void delete(K key) {
		root = delete(root, key);
	}
	
	private Node delete(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = delete(r.left, key);
		else if (cmp > 0) r.right = delete(r.right, key);
		else {
			if (r.left == null) return r.right;
			else if (r.right == null) return r.left;
			Node tmp = r;
			r = min(r.right);
			r.left = tmp.left;
			r.right = deleteMin(tmp.right);
		}
		r.count = size(r.left) + size(r.right) + 1;
		return r;
	}
	
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node r) {
		if (r.left == null) return r.right;
		r.left = deleteMin(r.left);
		r.count = size(r.right) + size(r.left) + 1;
		return r;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size(root);
	}
	
	@Override
	public Iterable<K> keys() {
		Queue<K> queue = new LinkedList<>();
		inorder(root, queue);
		return queue;
	}

	private void inorder(Node r, Queue<K> queue) {
		if (r != null) {
			inorder(r.left, queue);
			queue.add(r.key);
			inorder(r.right, queue);
		}
	}
	
	@Override
	public K min() {
		Node min = min(root);
		return min.key;
	}
	
	private Node min(Node r) {
		if (r.left == null) return r;
		return min(r.left);
	}

	@Override
	public K max() {
		Node max = max(root);
		return max.key;
	}
	
	private Node max(Node r) {
		if (r.right == null) return r;
		return min(r.right);
	}
	
	@Override
	public K floor(K key) {
		Node f = floor(root, key);
		return (f != null)? f.key : null;
	}
	
	private Node floor(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp < 0) return floor(r.left, key);
		else if (cmp > 0) {
			Node f = floor(r.right, key);
			return (f != null)? f : r; 
		}
		return r; 
	}

	@Override
	public K ceiling(K key) {
		Node c = ceiling(root, key);
		return (c != null)? c.key : null;
	}
	
	private Node ceiling(Node r, K key) {
		if (r == null) return null;
		int cmp = key.compareTo(r.key);
		if (cmp > 0) return ceiling(r.right, key);
		else if (cmp < 0) {
			Node c = ceiling(r.left, key);
			return (c != null)? c : r; 
		}
		return r; 
	}

	@Override
	public K select(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		return null;
	}
	

	@Override
	public int rank(K key) {
		return rank(root, key);
	}
	
	private int rank(Node r, K key) {
		if (r == null) return 0;
		int cmp = (key.compareTo(r.key));
		if (cmp > 0) return 1 + size(r.left) + rank(r.right, key);
		else if (cmp < 0) return rank(r.left, key);
		return size(r.left);
	}
	
	

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

















