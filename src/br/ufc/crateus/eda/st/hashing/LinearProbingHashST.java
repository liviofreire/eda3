package br.ufc.crateus.eda.st.hashing;

import br.ufc.crateus.eda.st.ST;

public class LinearProbingHashST<K, V> implements ST<K, V> {
	
	int m;
	
	private K[] keys;
	private V[] values;
	
	public LinearProbingHashST() {
		this(97);
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashST(int m) {
		this.m = m;
		this.keys = (K[]) new Object[m];
		this.values = (V[]) new Object[m];
	}
	
	private int hash(K key) {
		return (key.hashCode() & 0x7fffffff) % m;
	}

	@Override
	public void put(K key, V value) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i])) i = (i + 1) % m;
		keys[i] = key;
		values[i] = value; 
	}

	@Override
	public V get(K key) {
		int i = hash(key);
		while (keys[i] != null && !key.equals(keys[i])) i = (i + 1) % m;
		return values[i];
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
