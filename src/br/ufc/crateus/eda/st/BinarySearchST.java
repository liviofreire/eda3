package br.ufc.crateus.eda.st;

import java.util.Map.Entry;

import br.ufc.crateus.eda.util.ArrayVar;

public class BinarySearchST<K extends Comparable<K>, V> implements ST<K, V> {
	ArrayVar<Entry<K, V>> array = new ArrayVar<>();
	
	private int rank(K key) {
		int lo = 0, hi = array.length() - 1;
		while (lo < hi) {
			int m = (lo + hi) / 2;
			int cmp = key.compareTo(array.get(m).getKey());
			if (cmp < 0) hi = m - 1;
			else if (cmp > 0) lo = m + 1;
			return m;
		}
		return lo;
	}

	@Override
	public void put(K key, V value) {
		int j = rank(key);
		if (j < array.length()) { 
 			Entry<K, V> entry = array.get(j);
 			if (key.equals(entry.getKey())) entry.setValue(value);
 			else array.add(j, new STEntry<K, V>(key, value));
		}
		else array.add(new STEntry<K, V>(key, value));
	}

	@Override
	public V get(K key) {
		int j = rank(key);
		if (j < array.length()) { 
 			Entry<K, V> entry = array.get(j);
 			if (key.equals(entry.getKey())) return entry.getValue();
		}
		return null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

}
