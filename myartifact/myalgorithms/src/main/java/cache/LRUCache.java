package cache;

public interface LRUCache<K, V> {

	void put(K k, V v);

	V get(K k);

	int getCacheEntries();

	void showCache();
}
