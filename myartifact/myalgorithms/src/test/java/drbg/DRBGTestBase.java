package drbg;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import drbg.datagen.TestDataStore;

public class DRBGTestBase {

	public TestDataStore ds;

	public DRBGTestBase(TestDataStore ds) {
		this.ds = ds;
	}

	public static List<TestDataStore> fromJson(File testFile) {
		Gson gson = new Gson();
		JsonElement json;
		try {
			json = new JsonParser().parse(new FileReader(testFile));
			JsonArray array = json.getAsJsonArray();
			Iterator<JsonElement> iterator = array.iterator();

			List<TestDataStore> testDataList = new ArrayList<TestDataStore>();

			while (iterator.hasNext()) {
				JsonElement json2 = (JsonElement) iterator.next();
				TestDataStore ds = gson.fromJson(json2, TestDataStore.class);
				testDataList.add(ds);
			}
			assertTrue(testDataList.size() > 0);
			return testDataList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
