package drbg;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class DataProducer {

	@Test
	public void test() {
		readTestData();
	}

	private void readTestData() {
		// Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("drbg/hash_drbg.txt")
				.getFile());
		Pattern sha = Pattern.compile("Requested Hash Algorithm = (SHA-\\d+)");
		Matcher m;
		StringBuffer sbuf = new StringBuffer();
		int counter = 1;
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.trim();
				if (line.contains("Hashgen")) {
					if (counter == 1) {
						line = "<Hashgen" + counter + ">";
					} else {
						line = "</Hashgen" + (counter - 1) + ">\n";
						line += "<Hashgen" + (counter) + ">";
					}
					counter++;
				}
				sbuf.append(line);
			}
			sbuf.append("</Hashgen" + (counter - 1) + ">\n");
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println("counter#" + counter);
		String bigLine = sbuf.toString();
		m = sha.matcher(bigLine);
		List<String> shaList = new ArrayList<String>();
		List<String> rnobList = new ArrayList<String>();
		List<String> dataList = new ArrayList<String>();
		List<String> rtbList = new ArrayList<String>();
		while (m.find()) {
			shaList.add(m.group(1).toString().toUpperCase()
					.replace("SHA-", "SHA"));
			continue;
		}
		for (int i = 1; i <= counter; i++) {
			Pattern hashgen = Pattern
					.compile("<Hashgen"
							+ i
							+ ">[\\s]*requested_no_of_bits = (\\d+).*(data is)(.*)(w_i is)(.*)"
							+ "(i = 2).*(returned_bits is)\\s*(.*)(---------------------------)(Update V).*"
							+ "</Hashgen" + i + ">");
			m = hashgen.matcher(bigLine);
			if (m.find()) {
				rnobList.add(m.group(1).toString());
				dataList.add(m.group(3).toString().replaceAll(" ", ""));
				rtbList.add(m.group(8).toString().replaceAll(" ", ""));
			}
		}
		// System.out.println(shaList.size());
		// System.out.println(rnobList.size());
		// System.out.println(dataList.size());
		// System.out.println(rtbList.size());
		for (int i = 0; i < shaList.size(); i++) {
			String testdata = String
					.format("data.add(new Object[] {\nnew %s(PROVIDER),\n440,\n%s,\nnew StringBuffer().append(\"%s\").toString(),\nnew StringBuffer().append(\"%s\").toString(),\n});",
							shaList.get(i), rnobList.get(i), dataList.get(i),
							rtbList.get(i));
			System.out.println(testdata);
		}

	}
}
