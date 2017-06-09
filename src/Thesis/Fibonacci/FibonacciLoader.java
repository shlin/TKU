/**
 * 
 */
package Thesis.Fibonacci;

import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

/**
 * @author pstar
 *
 */
public class FibonacciLoader implements Runnable {
	private int n;
	private OperatingSystemMXBean osmb;
	private final int mb = 1024 * 1024;

	public FibonacciLoader(int n) {
		this.n = n;
		this.osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
	}

	@Override
	public void run() {
		while (true) {
			if (osmb.getFreePhysicalMemorySize() / mb <= 200)
				break;

			try {
				Thread newFib = new Thread(() -> {
					try {
						long start = System.currentTimeMillis();
						new Fibonacci().getFibNWithLoop(n);
						System.out.println(System.currentTimeMillis() - start);
					} catch (Exception | Error e) {
						throw new RuntimeException(e);
					}
				});
				newFib.start();
				Thread.sleep(5);
			} catch (Exception | Error e) {
				e.printStackTrace();
				System.exit(0);
			}
		}
	}

}
