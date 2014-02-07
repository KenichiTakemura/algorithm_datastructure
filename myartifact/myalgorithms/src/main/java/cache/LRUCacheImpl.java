package cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

	private final Map<K, Entry<K, V>> cache;
	private Entry<K, V> head;
	private Entry<K, V> tail;
	private final int lruSize;

	public LRUCacheImpl(int lruSize) {
		if (lruSize <= 0) {
			throw new IllegalArgumentException("size should at least be one");
		}
		cache = new HashMap<K, Entry<K, V>>();
		this.lruSize = lruSize;
	}

	private static class Entry<K, V> {
		K key;
		V value;
		//Entry<K, V> left;
		//Entry<K, V> right;
		Entry<K, V> next;
		
		//Entry(K key, V value, Entry<K, V> left, Entry<K, V> right) {
		Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			//this.left = left;
			//this.right = right;
			this.next = next;
		}

	};

	/**
	 * Head is first node of the linked list. Similar to - convert tree to
	 * doubly linkedlist.
	 */
	private void addLast(Entry<K, V> entry) {
		if (head == null) {
			//entry.left = entry.right = entry;
			entry.next = entry;
			head = tail = entry;
		} else {
			remove(entry);
			tail.next = entry;
			entry.next = head;
			tail = entry;
		}
	}

	private void remove(Entry<K, V> entry) {
		if(entry != null) {
			
			if (entry.next != null)
				entry.left.right = entry.right;
			if (entry.right != null)
				entry.right.left = entry.left;
			if (entry == eldest)
				eldest = entry.right;
		}
	}

	/**
	 * Allowing null. Since, this is behavior of linkedhashmap. Still adding
	 * synchronization as interviewer is bound to ask this question
	 */
	public synchronized void put(K key, V value) {
		Entry<K, V> entry = new Entry<K, V>(key, value, null, null);
		cache.put(key, entry);
		addFirst(entry);

		if (removeEldestEntry()) {
			remove(eldest.key);
		}
	}

	public synchronized V get(K key) {
		Entry<K, V> entry = cache.get(key);
		if (entry != null) {
			addFirst(entry);
			return entry.value;
		}
		return null;
	}

	public synchronized void remove(K key) {
		Entry<K, V> entry = cache.remove(key);
		if (entry != null) {
			remove(entry);
		}
	}

	private boolean removeEldestEntry() {
		return cache.size() > lruSize;
	}

	@Override
	public int getCacheEntries() {
		return cache.size();
	}

	@Override
	public void showCache() {
		System.out.println("Cache: " + cache);
	}

}
