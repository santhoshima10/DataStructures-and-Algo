package hashmap;

public class Entry<K,V> {
	
	private int hashcode;
	private K key;
	private V value;
	private Entry<K,V> next;
	
	public Entry(int hashcode , K key, V value) {
		this.hashcode = hashcode;
		this.key = key;
		this.value = value;
		this.next = null;
	}
	
	public int getHashcode() {
		return hashcode;
	}
	public void setHashcode(int hashcode) {
		this.hashcode = hashcode;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public Entry<K, V> getNext() {
		return next;
	}
	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

}
