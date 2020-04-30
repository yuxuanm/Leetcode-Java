package leetcode;

import java.util.Arrays;

public class Q146 {
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2 /* capacity */ );
		System.out.println(cache.get(2));
		cache.put(2, 6);
		System.out.println(cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));

//		cache.put(1, 1);
//		cache.put(2, 2);
//		cache.get(1);       // returns 1
//		cache.put(3, 3);    // evicts key 2
//		cache.get(2);       // returns -1 (not found)
//		cache.put(4, 4);    // evicts key 1
//		cache.get(1);       // returns -1 (not found)
//		System.out.println(cache.get(3));
//		System.out.println(cache.get(4));
//		cache.get(3);       // returns 3
//		cache.get(4);       // returns 4

	}
}

class LRUCache {
	private int[] keys;
	private int[] values;

	public LRUCache(int capacity) {
		keys = new int[capacity];
		values = new int[capacity];
		Arrays.fill(values, -1);
	}

	public int get(int key) {
		for (int i = 0; i < keys.length; i++) {
			if (keys[i] == key) {
				int res = values[i];
				change(keys, i);
				change(values, i);
				return res;
			}
		}
		return -1;
	}

	public void change(int[] arr, int index) {
		int tmp = arr[index];
		for (int i = index; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = tmp;
	}

	public void put(int key, int value) {
		for (int i = keys.length - 1; i > 0; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[0] = key;
		values[0] = value;
	}
}