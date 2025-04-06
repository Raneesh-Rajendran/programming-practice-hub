package main.java.low_code.rate_limiter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterService {
  private final RateLimiter rateLimiter;
  private static final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  public RateLimiterService(RateLimiterType type, int maxRequests, long windowMillis) {
    this.rateLimiter = RateLimiterFactory.createRateLimiter(type, maxRequests, windowMillis);
  }

  public void handleRequest(String userId) {
    String timestamp = "[" + LocalDateTime.now().format(formatter) + "]";
    if (rateLimiter.allow(userId)) {
      System.out.println(timestamp + " Request allowed for user: " + userId);
    } else {
      System.out.println(timestamp + " Rate limit exceeded for user: " + userId);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    // Create the rate limiter service
    RateLimiterService service = new RateLimiterService(RateLimiterType.FIXED_WINDOW, 5, 60000);

    // Simulate two users
    String user1 = "user1";
    String user2 = "user2";

    // Create a thread pool with 4 threads
    ExecutorService executor = Executors.newFixedThreadPool(4);

    // Submit 10 requests for each user concurrently
    for (int i = 0; i < 10; i++) {
      executor.submit(() -> service.handleRequest(user1));
      executor.submit(() -> service.handleRequest(user2));
    }

    // Shutdown executor and wait for tasks to finish
    executor.awaitTermination(10, TimeUnit.SECONDS);
    executor.shutdown();
  }
}
