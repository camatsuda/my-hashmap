package camatsuda.MyHashMap;

public class Main {

	public static void main(String[] args) {
		HashMapImpl map = new HashMapImpl();
		map.put(new Key(1), new Value(2));
		map.put(new Key(3), new Value(4));
		map.put(new Key(6), new Value(7));
		
		map.remove(new Key(6));
		
		map.containsKey(new Key(6));
		map.containsKey(new Key(3));
	}

}
