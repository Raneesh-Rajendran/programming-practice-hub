package main.java.miscellaneous;

import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class IdManager {

  private final Set<Integer> inUseIds;
  private final Queue<Integer> idPool;
  private final int maxIds;

  public IdManager(int maxIds) {
    if (maxIds <= 0) throw new IllegalArgumentException("maxIds must be > 0");

    this.maxIds = maxIds;
    this.inUseIds = ConcurrentHashMap.newKeySet();
    this.idPool = new ConcurrentLinkedQueue<>();

    for (int i = 0; i < maxIds; i++) {
      idPool.offer(i);
    }
  }

  /**
   * Allocate an ID from the pool.
   *
   * @return allocated ID
   * @throws RuntimeException if no IDs are available
   */
  public synchronized int getId() {
    Integer id = idPool.poll();
    if (id == null) {
      throw new RuntimeException("All IDs are in use.");
    }
    inUseIds.add(id);
    return id;
  }

  /**
   * Release an ID back to the pool for reuse.
   *
   * @param id the ID to release
   */
  public synchronized void releaseId(int id) {
    if (id < 0 || id >= maxIds) {
      throw new IllegalArgumentException("Invalid ID: " + id);
    }

    if (inUseIds.remove(id)) {
      idPool.offer(id);
    } else {
      System.out.println("Warning: Attempted to release an ID not in use: " + id);
    }
  }

  // Optional helpers
  public int getUsedCount() {
    return inUseIds.size();
  }

  public int getAvailableCount() {
    return idPool.size();
  }
}
