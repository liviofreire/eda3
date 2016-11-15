package br.ufc.crateus.eda.util;

import java.util.Date;

public class Transaction {
	String who;
	Date when;
	int amount;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((when == null) ? 0 : when.hashCode());
		result = prime * result + ((who == null) ? 0 : who.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (amount != other.amount)
			return false;
		if (when == null) {
			if (other.when != null)
				return false;
		} else if (!when.equals(other.when))
			return false;
		if (who == null) {
			if (other.who != null)
				return false;
		} else if (!who.equals(other.who))
			return false;
		return true;
	}	
	
	public static void main(String[] args) {
		System.out.println(-3);
		System.out.println(Math.abs(-3));
		
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Math.abs(Integer.MIN_VALUE));
	}
}
