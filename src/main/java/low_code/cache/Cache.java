package main.java.low_code.cache;

public interface Cache<K, V> {
  void put(K key, V value, long ttlInMills);
  V get(K key);
  boolean containKey(K key);
  boolean remove(K key);
  void clear();
  int size();
}
