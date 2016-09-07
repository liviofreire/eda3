package br.ufc.crateus.eda.util;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayVar<T> implements Iterable<T> {
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

	public void remove(int j) {
		for(int i = j; i < length - 1; i++) array[i] = array[i + 1];
		length--;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int cursor = 0;
			
			@Override
			public boolean hasNext() {
				return cursor < length;
			}

			@Override
			public T next() {
				return array[cursor++];
			}
		};
	}
	
	public static void main(String[] args) {
		ArrayVar<Integer> arr = new ArrayVar<>(3);
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(6);
		arr.add(7);
		
		for (Integer i : arr) {
			System.out.println(i);
		}
	}
}











