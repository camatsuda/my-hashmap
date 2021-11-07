package camatsuda.MyHashMap;
import java.util.Objects;

public class Value {

	private int value;
	
	public Value(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Value other = (Value) obj;
		if (value != other.value) return false;
		return true;
	};
	
	
}
