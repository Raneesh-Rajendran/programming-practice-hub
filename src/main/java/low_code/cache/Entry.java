package main.java.low_code.cache;

public class Entry<V> {
  V value;
  long ttl;

  public Entry(V value, long ttl) {
    this.value = value;
    this.ttl = System.currentTimeMillis() + ttl;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }

  public long getTtl() {
    return ttl;
  }

  public void setTtl(long ttl) {
    this.ttl = ttl;
  }

  public boolean isExpired() {
    return System.currentTimeMillis() > ttl;
  }
}
