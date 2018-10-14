package edu.nyu.cs9053.homework8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMultiMap<K, V> implements Multimap<K, V> {

	private Map<K, ArrayList<V>> value;
	
	public HashMultiMap() {
		value = new HashMap<K, ArrayList<V>>();
	}
	
	@Override
	public void clear() {
		value.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return value.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return this.value.containsValue(value);
	}

	@Override
	public Set<Entry<K, Collection<V>>> entrySet() {
		Set<Entry<K, Collection<V>>> res = new HashSet<Entry<K, Collection<V>>>();
		for (Entry<K, ArrayList<V>> entry : value.entrySet()) {
			if (entry == null) 
				continue;
			Collection<V> value = entry.getValue();
			K key = entry.getKey();
			Entry<K, Collection<V>> entryToInsert = new MyEntry<K, Collection<V>>(key, value);
			res.add(entryToInsert);
		}
		return res;
	}

	@Override
	public Collection<V> get(Object key) {
		return value.get(key);
	}

	@Override
	public boolean isEmpty() {
		return value.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return value.keySet();
	}

	@Override
	public Collection<V> put(K key, Collection<V> value) {
		if (value.getClass() != this.value.getClass()) {
			throw new IllegalArgumentException();
		}
		return this.value.put(key, (ArrayList<V>) value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends Collection<V>> m) {
		if (m.getClass() != this.value.getClass()) {
			throw new IllegalArgumentException();
		}
		value.putAll((Map<? extends K, ? extends ArrayList<V>>) m);
	}

	@Override
	public Collection<V> remove(Object key) {
		return value.remove(key);
	}

	@Override
	public int size() {
		return value.size();
	}

	@Override
	public Collection<Collection<V>> values() {
		Collection<Collection<V>> res = new ArrayList<Collection<V>>();
		for (ArrayList<V> list : value.values()) {
			if (list.isEmpty() || list == null)
				continue;			
			res.add(list);
		}
		return res;
	}

	@Override
	public boolean putItem(K key, V value) {
		ArrayList<V> oldValue = this.value.get(key);
		if (this.value.containsKey(key)) {
			this.value.put(key, (ArrayList<V>) value);
			return (oldValue == value)? false : true;
			
		} else {
			this.value.put(key, (ArrayList<V>) value);
			return true;
		}
	}

	@Override
	public Collection<V> getItems(K key) {
		return value.get(key);
	}
	

	
}
