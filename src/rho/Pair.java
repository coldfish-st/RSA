package rho;

import java.math.BigInteger;

public class Pair {
	
	private BigInteger min;
	private BigInteger max;
	
	public Pair (BigInteger min, BigInteger max) {
		this.min = min;
		this.max = max;
	}
	
	public BigInteger getMin () {
		return min;
	}
	
	public BigInteger getMax () {
		return max;
	}
	
	public void changeMax (BigInteger i) {
		max = i;
	}
	
	public void changeMin (BigInteger i) {
		min = i;
	}
}
