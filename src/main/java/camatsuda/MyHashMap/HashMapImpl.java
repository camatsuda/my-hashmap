package camatsuda.MyHashMap;

import java.util.LinkedList;

public class HashMapImpl {

	LinkedList<Entry>[] hashMap = new LinkedList[2];

	int size = 0;
	
	public HashMapImpl() {}
	
	public void put (Key key, Value value) {
		if (size >= hashMap.length) {
			resize();
		}
		
		int index = key.hashCode() % hashMap.length;
		
		if (hashMap[index] == null) {
			hashMap[index] = new LinkedList<>();
			hashMap[index].add(new Entry(key, value));
			size++;
			return;
		} else {
			for (Entry e : hashMap[index]) {
				if (e.key.equals(key)) {
					e.value = value;
					//size++;
					return;
				}
			}
		}
		
		hashMap[index].add(new Entry(key, value));
		size++;
		return;
		
	}

	public Value get(Key key) {
		int index = key.hashCode() % hashMap.length;
		if (hashMap[index] == null) return null;
		
		for (Entry e : hashMap[index]) {
			if (e.key.equals(key)) {
				return e.value;
			}
		}
		
		return null;
	}
	
	
	public void remove (Key key) {
		int index = key.hashCode() % hashMap.length;
		if (hashMap[index] == null) return;
		
		Entry removed = null;

		for (Entry e : hashMap[index]) {
			if (e.key.equals(key)) {
				removed = e;
				break;
			}
		}
		if (removed == null) return;
		
		hashMap[index].remove(removed);
		size--;
	}
	
	public boolean containsKey(Key key) {
		if (key == null) return false;
		int index = key.hashCode() % hashMap.length;
		if (hashMap[index] == null) return false;
		
		for (Entry e : hashMap[index]) {
			if (e.key.equals(key)) {
				return true;
			}
		}
		return false;
	}

	public void resize() {
		LinkedList<Entry>[] oldHashMap = hashMap;
		hashMap = new LinkedList[size * 2];
		size = 0;
		
		for (int i = 0; i < oldHashMap.length; i++) {
			if (oldHashMap[i] == null) continue;
			for (Entry e : oldHashMap[i]) {
				put(e.key, e.value);
			}
		}
		
	}
}
