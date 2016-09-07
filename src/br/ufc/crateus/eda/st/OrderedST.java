package br.ufc.crateus.eda.st;

public interface OrderedST<K, V> extends ST<K, V> {
	K min();
	K max();
	K floor(K key);
	K ceiling(K key);
	K select(int i);
	Iterable<K> keys(K lo, K hi);
	int rank(K key);
	int size(K lo, K hi);
}
