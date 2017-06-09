/**
 * 
 */
package Thesis;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import com.sun.management.OperatingSystemMXBean;

import Thesis.Fibonacci.FibonacciLoader;

/**
 * @author pstar
 * @author shlin
 *
 */
public class Main {

	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		int mb = 1024 * 1024;
		OperatingSystemMXBean osmb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

		Thread fibLoader = new Thread(new FibonacciLoader(Integer.parseInt(args[0])));
		fibLoader.start();

		while (true) {
			System.out.printf("Process: %d\tCPU: %f%%\tRAM: %d MB\n",
					ManagementFactory.getThreadMXBean().getThreadCount() - 4, osmb.getSystemCpuLoad() * 100,
					osmb.getFreePhysicalMemorySize() / mb);
			if (osmb.getFreePhysicalMemorySize() / mb <= 150)
				System.exit(0);

			Thread.sleep(500);
		}
	}

}
