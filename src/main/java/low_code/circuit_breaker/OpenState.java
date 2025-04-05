package main.java.low_code.circuit_breaker;

import java.time.Duration;
import java.time.Instant;

public final class OpenState implements CircuitBreakerState {

  private final Instant openedAt;
  private final Duration timeout;

  public OpenState(Duration timeout) {
    this.openedAt = Instant.now();
    this.timeout = timeout;
  }

  @Override
  public boolean allow() {
    return Instant.now().isAfter(openedAt.plus(timeout));
  }
}
