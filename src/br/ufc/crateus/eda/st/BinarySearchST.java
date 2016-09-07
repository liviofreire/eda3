package br.ufc.crateus.eda.st;

import java.util.Map.Entry;

import br.ufc.crateus.eda.util.ArrayVar;

public class BinarySearchST<K extends Comparable<K>, V> implements OrderedST<K, V> {
	ArrayVar<Entry<K, V>> array = new ArrayVar<>();
	
	public int rank(K key) {
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
		int j = rank(key);
		if (j < array.length()) {
 			Entry<K, V> entry = array.get(j);
 			if (key.equals(entry.getKey())) array.remove(j);
		}
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return array.length() == 0;
	}

	@Override
	public int size() {
		return array.length();
	}

	@Override
	public Iterable<K> keys() {
		ArrayVar<K> arr = new ArrayVar<>();
		for (Entry<K, V> entry : array)
			arr.add(entry.getKey());
		return arr;
	}

	@Override
	public K min() {
		return array.get(0).getKey();
	}

	@Override
	public K max() {
		// TODO Auto-generated method stub
		return array.get(array.length() - 1).getKey();
	}

	@Override
	public K floor(K key) {
		int j = rank(key);
		if (j < array.length()) {
			Entry<K, V> entry = array.get(j);
			if (key.equals(entry.getKey())) return key;
		}
		
		return (j > 0)? array.get(j - 1).getKey() : null;
	}

	@Override
	public K ceiling(K key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K select(int i) {
		return null;
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
	}
}
