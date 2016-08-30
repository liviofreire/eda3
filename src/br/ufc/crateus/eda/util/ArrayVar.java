package br.ufc.crateus.eda.util;

import java.util.Arrays;

public class ArrayVar<T> {
	private T[] array;
	private int length = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayVar(int size) {
		this.array = (T[]) new Object[size];
	}
	
	public ArrayVar() {
		this(10);
	}
	
	public void add(T val) {
		if (length == array.length) 
			resize();
		
		array[length++] = val; 
	}
	
	public void add(int i, T val) {
		if (length == array.length)
			resize();
		if (i < length) {
			for (int j = length; j > i; j--)
				array[j] = array[j - 1];
			array[i] = val;
			length++;
		}
	}
	
	public T get(int i) {
		return (i < length)? array[i] : null;
	}
	
	private void resize() {
		this.array = Arrays.copyOf(array, 2 * array.length);
	}
	
	public int length() {
		return length;
	}
}











