/**
 * 
 */
package Thesis.Fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @author pstar
 * @author shlin
 */
public class Fibonacci {
	private ArrayList<BigInteger> fib;

	public Fibonacci() {
		this.initList();
	}

	private void initList() {
		fib = new ArrayList<BigInteger>();
		fib.add(BigInteger.ZERO);
		fib.add(BigInteger.ONE);
	}

	public BigInteger getFibNWithLoop(int n) {
		if (n >= fib.size()) {
			for (int i = fib.size(); i <= n; i++) {
				fib.add(fib.get(i - 1).add(fib.get(i - 2)));
			}
		}
		return fib.get(n);
	}
}

