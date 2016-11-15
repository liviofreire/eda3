package br.ufc.crateus.eda.st.btree;

public class BTree<K extends Comparable<K>> {
	
	private Page<K> root;
	int m;
	
	public BTree(int m, K sentinel) {
		this.m = m;
		root = new PageBinarySearchST<>(m, true);
		root.insert(sentinel);
	}
	
	public boolean contains(K key) {
		return contains(root, key);
	}
	
	private boolean contains(Page<K> r, K key) {
		if (r.isExternal()) return r.holds(key);
		return contains(r.next(key), key);
	}
	
	public void add(K key) {
		add(root, key);
		if (root.hasOverflowed()) {
			Page<K> p = root.split();
			Page<K> newRoot = new PageBinarySearchST<>(m, false);
			newRoot.enter(p);
			newRoot.enter(root);
			root = newRoot;
		}
	}
	
	private void add(Page<K> r, K key) {
		if (r.isExternal()) r.insert(key); 
		else {
			Page<K> next = r.next(key);
			add(next, key);
			if (next.hasOverflowed()) {
				Page<K> p = next.split();
				r.enter(p);
			}
		}
	}

}
