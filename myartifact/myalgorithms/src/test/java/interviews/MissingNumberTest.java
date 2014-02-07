package interviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.TestIntercepter;

public class MissingNumberTest extends TestIntercepter {
	@Test(dataProvider = "dp")
	public void f(int missing) {
		final int maxNumber = 100;
		MissingNumber f = new MissingNumber();
		List<String> text = new ArrayList<String>();
		for (char c = 'a'; c <= 'z'; c++) {
			text.add(String.valueOf(c));
		}
		for (int i = 1; i <= maxNumber; i++) {
			if(i == missing) continue;
			text.add(String.valueOf(i));
		}
		Collections.shuffle(text);
		Assert.assertFalse(text.contains(String.valueOf(missing)));
		for (int i = 1; i <= maxNumber; i++) {
			if(i == missing) continue;
			Assert.assertTrue(text.contains(String.valueOf(i)), i + " is not included");
		}
		StringBuffer buf = new StringBuffer();
		int iMax = text.size() - 1;
		for(int i=0;;i++) {
			if(i >= iMax) break;
			buf.append(text.get(i) + ",");
		}
		buf.append(text.get(iMax));
		Assert.assertEquals(
				f.FindMissingNumber(buf.toString(), maxNumber),
				missing);
		Assert.assertEquals(
				f.FindMissingNumberXOR(buf.toString(), maxNumber),
				missing);

	}
	
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 20 } };
	}
}
