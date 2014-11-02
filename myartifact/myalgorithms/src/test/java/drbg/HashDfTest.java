package drbg;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import drbg.datagen.DataGenerator;
import drbg.datagen.HashDfDataGeneratorTest;
import drbg.datagen.TestDataStore;

@RunWith(Parameterized.class)
public class HashDfTest extends DRBGTestBase {
	
	private static File testFile = new File(new File(DataGenerator.DATA_PATH), HashDfDataGeneratorTest.JSONFILE);
	
	public HashDfTest(TestDataStore ds) {
		super(ds);
	}
	
	@Parameters
	public static Collection<Object[]> testData() {
		Collection<Object[]> data = new ArrayList<Object[]>();
		List<TestDataStore> testDataList = DRBGTestBase.fromJson(testFile);
		for(TestDataStore ds: testDataList) {
			data.add(new Object[]{ds});
		}
		return data;
	}
	
	@Test
	public void test() throws Exception {
		System.out.println("TestData: " + ds);
		Hash hash = new Hash(DigestAlg.getAlgbyName(ds.getDigest()));
		 // V
		byte[] ret = DRBGUtils.hash_df(hash, DRBGUtils.toByteArray(ds.getIn()), Integer.parseInt(ds.getBits()));
		assertArrayEquals(ret, DRBGUtils.toByteArray(ds.getOut()));
		// C
		ret = DRBGUtils.hash_df(hash, DRBGUtils.toByteArray(ds.getIn(1)), Integer.parseInt(ds.getBits()));
		assertArrayEquals(ret, DRBGUtils.toByteArray(ds.getOut(1)));
	}

}
