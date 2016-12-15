package br.ufc.crateus.eda.st.string;

public class TST<V> {
	
	private Node root; 
	
	private class Node {
		char ch;
		V value;
		Node left, mid, right;
		
		public Node(char ch) {
			this.ch = ch;
		}
	}
	
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node node, String key, V value, int d) {
		char ch = key.charAt(d);
		if (node == null) node = new Node(ch);
		if (ch < node.ch) node.left = put(node.left, key, value, d);
		else if (ch > node.ch) node.right = put(node.right, key, value, d);
		else if (d < key.length() - 1) node.mid = put(node.mid, key, value, d + 1);
		else node.value = value;
		return node;
	}
	
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? (V) node.value : null;
	}
	
	private Node get(Node node, String key, int d) {
		char ch = key.charAt(d);
		if (node == null) return null;
		if (ch < node.ch) return get(node.left, key, d);
		else if (ch > node.ch) return get(node.right, key, d);
		else if (d < key.length() - 1)  return get(node.mid, key, d + 1);
		else return node;
	}
	
}
