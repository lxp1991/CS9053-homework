package edu.nyu.cs9053.homework8;

import java.util.Map.Entry;

public class MyEntry<K, V> implements Entry<K, V> {
	//reference: http://stackoverflow.com/questions/3110547/java-how-to-create-new-entry-key-value
    private final K key;
    private V value;
    public MyEntry(final K key) {
        this.key = key;
    }
    public MyEntry(final K key, final V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public V setValue(final V value) {
        final V oldValue = this.value;
        this.value = value;
        return oldValue;
    }
	
}
