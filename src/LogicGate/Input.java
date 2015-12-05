package LogicGate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
	private int benchId;
	private File inputFile;
	private LinkedList<String> inputList;

	public Input(File inputFile) {
		this.inputFile = inputFile;
		this.benchId = initBenchId();
		this.inputList = new LinkedList<String>();
		this.read();
	}

	public void read() {
		try {
			Scanner input = new Scanner(inputFile);

			input.forEachRemaining(line -> {
				if (line.matches("[01]+")) {
					inputList.add(line);
				}
			});

			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the inputList
	 */
	public LinkedList<String> getInputList() {
		return inputList;
	}

	private int initBenchId() {
		Matcher matcher = Pattern.compile("c(\\d+?)-").matcher(inputFile.getName());

		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}

		return 0;
	}

	/**
	 * @return the benchId
	 */
	public int getBenchId() {
		return benchId;
	}

	/**
	 * @return the inputFile
	 */
	public File getInputFile() {
		return inputFile;
	}
}
