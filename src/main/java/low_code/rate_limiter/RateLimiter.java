package main.java.low_code.rate_limiter;

public interface RateLimiter {
  boolean allow(String userId);
}
