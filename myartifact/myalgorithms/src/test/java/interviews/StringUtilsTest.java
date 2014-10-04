package interviews;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StringUtilsTest {

	StringUtils r;

	@BeforeClass
	public void beforeClass() {
		r = new StringUtils();
	}
	
	@Test
	public void testContainsOther() {
		assertEquals(r.containsOther(null,null), 0);
		assertEquals(r.containsOther(null,"bar"), -1);
		assertEquals(r.containsOther("bar",null), -1);
		assertEquals(r.containsOther("ba","bar"), -1);
		assertEquals(r.containsOther("bar","bar"), 0);
		assertEquals(r.containsOther("Bar","bar"), -1);
		assertEquals(r.containsOther("rebar","bar"), 2);
		assertEquals(r.containsOther("barre","bar"), 0);
		assertEquals(r.containsOther("rebarbar","bar"), 2);
		assertEquals(r.containsOther("rebabar","bar"), 4);
		assertEquals(r.containsOther("BarbarbaR","bar"), 3);
	}

	//@Test
	public void f1() {
		assertEquals(r.reverse(""), "");
		assertEquals(r.reverse("t"), "t");
		assertEquals(r.reverse("st"), "ts");
		assertEquals(r.reverse("hello"), "olleh");
		assertEquals(r.reverse("bushsawsununuswashsub"),
				"bushsawsununuswashsub");
		assertEquals(r.reverse("kenichitakemura"), "arumekatihcinek");
		assertEquals(r.removeDuplicated(""), "");
		assertEquals(r.removeDuplicated("t"), "t");
		assertEquals(r.removeDuplicated("st"), "st");
		assertEquals(r.removeDuplicated("stt"), "st");
		assertEquals(r.removeDuplicated("sssstt"), "st");
		assertEquals(r.removeDuplicated("sssssttttttz"), "stz");
		assertEquals(r.removeDuplicated("ddddddddddddd"), "d");
	}

	//@Test
	public void f2() {
		assertTrue(r.bracketMatch(""));
		assertFalse(r.bracketMatch("{{{}}"));
		assertFalse(r.bracketMatch("(((((((())))))))))"));
		assertFalse(r.bracketMatch("]["));
		assertTrue(r.bracketMatch("((()))"));
		assertTrue(r.bracketMatch("(){}[]"));
		assertTrue(r.bracketMatch("{{{()(())[(())]}}}"));
		assertTrue(r.isAnagram("angered", "enraged"));
		assertTrue(r.isAnagram("angered", "grenade"));
		assertFalse(r.isAnagram("angered", "grenasde"));
		assertTrue(r.isAnagram("auctioned", "education"));

	}
}
