package drbg.datagen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HashDRBGDataGeneratorTest extends DataGenerator {
	
	public final static String JSONFILE = "hash_drbg_gen.json";
	
	@Test
	public void generate() {
		Collection<TestDataStore> out = generate("Hash_DRBG", "hash_drbg.txt");
		toJson(out, JSONFILE);
	}

	@Override
	TestDataStore coreMatcher(String inputline, String startTag, String endTag,
			int index) {
		TestDataStore ds = null;
		String pattern = new StringBuffer().append(startTag)
				.append("<l>(\\d+)</l>")
				.append(".*Requested Hash Algorithm = (SHA\\d+)")
				.append(".*prediction_resistance_flag = ([\\w\" ]+)")
				.append(" EntropyInput = ([0-9A-F ]+)")
				.append("EntropyInput1 \\(for Reseed1\\) =([0-9A-F ]+)")
				.append("EntropyInput2 \\(for Reseed2\\) =([0-9A-F ]+)")
				.append("Nonce =([0-9A-F ]+)")
				.append("PersonalizationString = ([\\w <>]+)")
				.append("AdditionalInput = ([\\w <>]+)")
				.append("<keyword>Hash_DRBG_Instantiate_algorithm.*")
				.append("</keyword>requested_number_of_bits = (\\d+).*")
				.append("rnd_val is([0-9A-F ]+)")
				.append(".*")
				.append(endTag).toString();
		Pattern hashgen = Pattern.compile(pattern);
		Matcher matcher = hashgen.matcher(inputline);
		if (matcher.find()) {
			ds = new TestDataStore(7, 1);
			ds.setLineNumber(Integer.parseInt(matcher.group(1).toString()));
			ds.setDigest(matcher.group(2).toString());
			ds.setBits(matcher.group(10).toString());
			ds.setIn(matcher.group(3).toString().replaceAll(" ", ""));
			ds.setIn(matcher.group(4).toString().replaceAll(" ", ""), 1);
			ds.setIn(matcher.group(5).toString().replaceAll(" ", ""), 2);
			ds.setIn(matcher.group(6).toString().replaceAll(" ", ""), 3);
			ds.setIn(matcher.group(7).toString().replaceAll(" ", ""), 4);
			ds.setIn(matcher.group(8).toString().replaceAll(" ", ""), 5);
			ds.setIn(matcher.group(9).toString().replaceAll(" ", ""), 6);
			ds.setOut(matcher.group(11).toString().replaceAll(" ", ""));
			System.out.println(ds);
		}
		return ds;
	}

}
