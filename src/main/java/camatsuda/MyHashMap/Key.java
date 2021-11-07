package camatsuda.MyHashMap;
import java.util.Objects;

public class Key {

	private int key;
	
	public Key(int key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Key other = (Key) obj;
		if (key != other.key) return false;
		return true;
	};
	
	
}
