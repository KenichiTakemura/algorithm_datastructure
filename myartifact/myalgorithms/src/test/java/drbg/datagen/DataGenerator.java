package drbg.datagen;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

public abstract class DataGenerator {
	
	public final static String DATA_PATH = "src/test/resources/drbg";

	int counter;

	File getWorkingFile(String target) {
		return new File(new File(DATA_PATH), "work_" + this.getClass().getSimpleName()
				+ ".txt");
	}

	public String analyse(String inputfilename, String target) {
		File file = new File(new File(DATA_PATH), inputfilename);
		Pattern shaPattern = Pattern
				.compile("Requested Hash Algorithm = (SHA-\\d+)");
		Matcher matcher;
		StringBuffer sbuf = new StringBuffer();
		String shaString = null;
		counter = 1;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			int lineNumber = 1;
			boolean shaIncluded = false;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				matcher = shaPattern.matcher(line);
				if (matcher.find()) {
					shaString = matcher.group(1).toUpperCase().replace("-", "");
				}
				line = line.replaceAll("[\\-]+", "");
				line = line.replaceAll("\\*+", "");
				line = line.replaceAll("\\#+", "");
				// Keywords
				if(line.contains("First call to Generate") ||
						line.contains("Second call to Generate") ||
						line.contains("Hash_DRBG_Generate_algorithm") ||
						line.contains("Hash_DRBG_Reseed_algorithm") ||
						line.contains("Hash_DRBG_Instantiate_algorithm")) {
					line = "<keyword>" + line + "</keyword>";
				} else if (line.contains(target)) {
					if (counter == 1) {
						line = "\n<" + target + counter + ">";
						line += "<l>" + lineNumber + "</l>";
						if(shaString != null) {
							line += "<d>" + shaString + "</d>";
							shaIncluded = true;
						}
					} else {
						line = "</" + target + (counter - 1) + ">\n";
						line += "<" + target + (counter) + ">";
						line += "<l>" + lineNumber + "</l>";
						if(shaIncluded) {
							line += "<d>" + shaString + "</d>";
						}
					}
					counter++;
				}
				sbuf.append(line);
				lineNumber++;
			}
			sbuf.append("</" + target + (counter - 1) + ">\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		counter--;
		String largeLine = sbuf.toString();
		System.out.println(largeLine);
		System.out.println(counter);
		BufferedWriter bw = null;
		File wf = getWorkingFile(target);
		try {
			wf.delete();
			bw = new BufferedWriter(new FileWriter(wf));
			bw.write(largeLine);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return largeLine;
	}

	protected void toJson(Object in, String outputfilenam) {
		try {
			File file = new File(new File(DATA_PATH), outputfilenam);
			Gson gson = new Gson();
			String json = gson.toJson(in);
			FileWriter writer = new FileWriter(file);
			writer.write(json);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected Collection<TestDataStore> generate(String target, String inputfilename) {
		String inputline = analyse(inputfilename, target);
		List<TestDataStore> outList = new ArrayList<TestDataStore>();
		for (int i = 1; i <= counter; i++) {
			String startTag = "<" + target + i + ">";
			String endTag = "</" + target + i + ">";
			TestDataStore ds = coreMatcher(inputline, startTag, endTag, i); 
			if(ds == null) {
				throw new RuntimeException("Not Found#" + i + " startTag#" + startTag);
			}
			if (!ds.isAllSet()) {
				throw new RuntimeException("All Data Not Found#" + i
						+ " DataStore#" + ds);
			}
			System.out.println(ds);
			outList.add(ds);
		}
		assertEquals(outList.size(), counter);
		return outList;
	}

	abstract TestDataStore coreMatcher(String inputline, String startTag,
			String endTag, int index);
}
