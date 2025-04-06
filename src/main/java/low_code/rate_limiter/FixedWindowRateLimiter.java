package main.java.low_code.rate_limiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter implements RateLimiter {

  private final int maxRequests;
  private final long windowTimeInMillis;
  private final Map<String, UserRequestInfo> store;

  public FixedWindowRateLimiter(int maxRequests, long windowTimeInMillis) {
    this.maxRequests = maxRequests;
    this.windowTimeInMillis = windowTimeInMillis;
    this.store = new ConcurrentHashMap<>();
  }

  @Override
  public boolean allow(String userId) {
    long currentTime = System.currentTimeMillis();
    store.putIfAbsent(userId, new UserRequestInfo(currentTime));

    UserRequestInfo info = store.get(userId);
    synchronized (info) {
      if (currentTime - info.windowStart >= windowTimeInMillis) {
        info.reset(currentTime);
      }
      if (info.requestCount.get() < maxRequests) {
        info.requestCount.incrementAndGet();
        return true;
      } else {
        return false;
      }
    }
  }

  private static class UserRequestInfo {
    long windowStart;
    AtomicInteger requestCount;

    public UserRequestInfo(long windowStart) {
      this.windowStart = windowStart;
      this.requestCount = new AtomicInteger(0);
    }

    void reset(long newWindowStart) {
      this.windowStart = newWindowStart;
      requestCount.set(0);
    }
  }
}
