package main.java.low_code.cache;

public class Runner {
  public static void main(String[] args) throws InterruptedException {
    Cache<String, String> cache = new TTLCache<>();

    cache.put("user", "Raneesh", 3000); // 3 seconds TTL
    System.out.println("Immediately: " + cache.get("user")); // Raneesh

    Thread.sleep(4000);
    System.out.println("After 4 seconds: " + cache.get("user")); // null

    cache.put("user1", "Raj", 10000); // 3 seconds TTL
    System.out.println("Immediately: " + cache.get("user1")); // Raj

    cache.put("user2", "Sharma", 10000); // 3 seconds TTL
    System.out.println("Immediately: " + cache.get("user2")); // Sharma

    System.out.println("Contains User 2: " + cache.containKey("user2")); // true

    cache.clear();

    System.out.println("After Clear Size: " + cache.size()); // 0

  }
}
