package drbg.datagen;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HashGenDataGeneratorTest extends DataGenerator {

	@Test
	public void generate() {
		Collection<TestDataStore> out = generate("Hashgen", "hash_drbg.txt");
		toJson(out, "hashgen_hash_drbg.json");
	}

	@Override
	TestDataStore coreMatcher(String inputline, String startTag, String endTag,
			int index) {
		TestDataStore ds = null;
		String pattern = new StringBuffer().append(startTag)
				.append("<l>(\\d+)</l>").append("<d>(.+)</d>")
				.append(".*requested_no_of_bits = (\\d+).*(data is)([\\w ]+)")
				.append("w_i is(.*)(i = 2).*(returned_bits is)([\\w ]+)")
				.append("(Update V)").append(".*").append(endTag).toString();
		Pattern hashgen = Pattern.compile(pattern);
		Matcher matcher = hashgen.matcher(inputline);
		if (matcher.find()) {
			ds = new TestDataStore();
			ds.setLineNumber(Integer.parseInt(matcher.group(1).toString()));
			ds.setDigest(matcher.group(2).toString());
			ds.setBits(matcher.group(3).toString());
			ds.setIn(matcher.group(5).toString().replaceAll(" ", ""));
			ds.setOut(matcher.group(9).toString().replaceAll(" ", ""));
		}
		return ds;
	}
}
