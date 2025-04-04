package main.java.low_code.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TTLCache<K, V> implements Cache<K, V> {
  private final Map<K, Entry<V>> store;

  public TTLCache() {
    this.store = new ConcurrentHashMap<>();
    startCleaner();
  }

  private void startCleaner() {
    Thread thread =
        new Thread(
            () -> {
              while (true) {
                try {
                  Thread.sleep(5000);
                  for (K key : store.keySet()) {
                    Entry<V> entry = store.get(key);
                    if (entry != null && entry.isExpired()) store.remove(key);
                  }
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            });
    thread.setDaemon(
        true); // To make the JVM exit the program without worrying about the cleaner thread
    thread.start();
  }

  @Override
  public void put(K key, V value, long ttlInMills) {
    store.put(key, new Entry<>(value, ttlInMills));
  }

  @Override
  public V get(K key) {
    Entry<V> entry = store.get(key);
    if (entry == null || entry.isExpired()) {
      return null;
    }
    return entry.getValue();
  }

  @Override
  public boolean containKey(K key) {
    Entry<V> entry = store.get(key);
    return entry != null && !entry.isExpired();
  }

  @Override
  public boolean remove(K key) {
    return store.remove(key) != null;
  }

  @Override
  public void clear() {
    store.clear();
  }

  @Override
  public int size() {
    return store.size();
  }
}
