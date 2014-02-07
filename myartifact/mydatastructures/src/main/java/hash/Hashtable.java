package hash;

public interface Hashtable<K, V> {

	void put(K key, V value);

	V get(K key);

	int size();

	void clear();

	boolean isEmpty();
}
