package main.java.miscellaneous;

import java.util.*;

public class WriteOnceMap<K, V> implements Map<K, V> {

  private final Map<K, V> map;

  public WriteOnceMap(Map<K, V> map) {
    this.map = map;
  }

  @Override
  public V put(K key, V value) {
    if (map.containsKey(key)) {
      throw new UnsupportedOperationException("Key already exists: " + key);
    }
    return map.put(key, value);
  }

  @Override
  public V remove(Object key) {
    return null;
  }

  @Override
  public void putAll(Map<? extends K, ? extends V> newMap) {
    for (K key : newMap.keySet()) {
      if (map.containsKey(key)) {
        throw new UnsupportedOperationException("Key already exists: " + key);
      }
    }
    map.putAll(newMap);
  }

  @Override
  public void clear() {
    map.clear();
  }

  @Override
  public Set<K> keySet() {
    return map.keySet();
  }

  @Override
  public Collection<V> values() {
    return map.values();
  }

  @Override
  public Set<Entry<K, V>> entrySet() {
    return map.entrySet();
  }

  @Override
  public V get(Object key) {
    return map.get(key);
  }

  @Override
  public int size() {
    return map.size();
  }

  @Override
  public boolean isEmpty() {
    return map.isEmpty();
  }

  @Override
  public boolean containsKey(Object key) {
    return map.containsKey(key);
  }

  @Override
  public boolean containsValue(Object value) {
    return map.containsValue(value);
  }
}
