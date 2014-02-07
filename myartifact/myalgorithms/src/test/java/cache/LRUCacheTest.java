package cache;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import org.testng.annotations.Test;

public class LRUCacheTest {
	@Test
	public void f() {
		LRUCache<String, Integer> cache = new LRUCacheImpl<>(5);
		int k = 0;
		for(String s:new String[]{"a","b","c","d","e","f","g"}) {
			cache.put(s, k++);
		}
		assertEquals(cache.getCacheEntries(), 5);
		cache.showCache();
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("b"));
		assertNotNull(cache.get("c"));
		assertNotNull(cache.get("d"));
		assertNotNull(cache.get("e"));
		assertNotNull(cache.get("f"));
		assertNotNull(cache.get("f"));
		assertNotNull(cache.get("a"));
		assertNull(cache.get("z"));
		cache.showCache();
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("a"));
		assertNotNull(cache.get("a"));

	}
}
