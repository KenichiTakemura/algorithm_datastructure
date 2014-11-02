package drbg.datagen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HashDfDataGeneratorTest extends DataGenerator {
	
	public final static String JSONFILE = "hashdf_hash_drbg.json";
	
	@Test
	public void generate() {
		Collection<TestDataStore> out = generate("Hash_df  Generate seed", "hash_drbg.txt");
		toJson(out, JSONFILE);
	}

	@Override
	TestDataStore coreMatcher(String inputline, String startTag, String endTag,
			int index) {
		TestDataStore ds = null;
		String pattern = new StringBuffer().append(startTag)
				.append("<l>(\\d+)</l>").append("<d>(.+)</d>")
				.append(".*(seed_material is)([\\w ]+)")
				.append(".*no_of_bits_to_return = (\\d+).*")
				.append("V is([\\w ]+)")
				.append("Hash_df  Generate C.*(V is)([0-9A-F ]+)no_of_bits_to_return =.*(C is)([0-9A-F ]+)<keyword>")
				.append(".*").append(endTag).toString();
		Pattern hashgen = Pattern.compile(pattern);
		Matcher matcher = hashgen.matcher(inputline);
		if (matcher.find()) {
			ds = new TestDataStore(2, 2);
			ds.setLineNumber(Integer.parseInt(matcher.group(1).toString()));
			ds.setDigest(matcher.group(2).toString());
			ds.setBits(matcher.group(5).toString());
			ds.setIn(matcher.group(4).toString().replaceAll(" ", ""));
			ds.setIn(matcher.group(8).toString().replaceAll(" ", ""), 1);
			ds.setOut(matcher.group(6).toString().replaceAll(" ", ""));
			ds.setOut(matcher.group(10).toString().replaceAll(" ", ""), 1);
			System.out.println(ds);
			assertEquals(ds.getOut().length(), (ds.getIn(1).length() - 2));
			assertEquals(Integer.parseInt(ds.getBits()) / 4, ds.getOut().length());
			assertEquals(Integer.parseInt(ds.getBits()) / 4, ds.getOut(1).length());
		}
		return ds;
	}

}
