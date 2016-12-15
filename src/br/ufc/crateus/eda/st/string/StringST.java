package br.ufc.crateus.eda.st.string;

import java.util.LinkedList;
import java.util.Queue;

public class StringST<V>{
	
	private static final int R = 256;
	
	private Node root = new Node();
	
	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}
	
	public void put(String key, V value) {
		put(root, key, value, 0);
	}
	
	private Node put(Node node, String key, V value, int d) {
		
		if (node == null) node = new Node();
		if (d == key.length()) {
			node.value = value;
		}
		else {
			char ch = key.charAt(d);
			node.next[ch] = put(node.next[ch], key, value, d + 1);
		}
		
		return node;
	}
	
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? (V) node.value : null;
	}
	
	public String longestPreffixOf(String query) {
		int length = search(root, query, 0, 0);
		return query.substring(0, length);
	}
	
	private int search(Node node, String query, int d, int length) {
		if (node == null) return length;
		if (node.value != null) length = d;
		if (d == query.length()) return length;
		char ch = query.charAt(d);
		return search(node.next[ch], query, d + 1, length);
	}
	
	private Node get(Node node, String key, int d){
		if (node == null) return null;
		if (d == key.length()) return node;
		char ch = key.charAt(d);
		return get(node.next[ch], key, d + 1);
	}
	
	public Iterable<String> keysWithPreffix(String preffix) {
		Node node = get(root, preffix, 0);
		Queue<String> queue = new LinkedList<String>();
		collect(node, preffix, queue);
		return queue;
	}
	
	public Iterable<String> keys() {
		Queue<String> queue = new LinkedList<String>();
		collect(root, "", queue);
		return queue;
	}
	
	private void collect(Node node, String preffix, Queue<String> keys) {
		if (node != null) {
			if (node.value != null) keys.add(preffix);
			for (char c = 0; c < R; c++) collect(node.next[c], preffix + c, keys);
		}
	}
	
}
