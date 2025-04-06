package main.java.low_code.rate_limiter;

import java.util.Objects;

public class RateLimiterFactory {
  public static RateLimiter createRateLimiter(
      RateLimiterType type, int maxRequests, long timeWindowMillis) {
    if (Objects.requireNonNull(type) == RateLimiterType.FIXED_WINDOW) {
      return new FixedWindowRateLimiter(maxRequests, timeWindowMillis);
    }
    throw new UnsupportedOperationException("Unsupported RateLimiterType: " + type);
  }
}
