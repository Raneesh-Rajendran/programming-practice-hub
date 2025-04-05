package main.java.low_code.circuit_breaker;

import java.time.Duration;

public class CircuitBreaker {

  private final int failureThreshold;
  private final int successThreshold;
  private final Duration openStateTimeout;
  private CircuitBreakerState state = new ClosedState();

  public CircuitBreaker(int failureThreshold, int successThreshold, Duration openStateTimeout) {
    this.failureThreshold = failureThreshold;
    this.successThreshold = successThreshold;
    this.openStateTimeout = openStateTimeout;
  }

  public boolean allowRequest() {
    //  Logic is here bcz context takes the responsibility of time based switching
    if (state instanceof OpenState openState && openState.allow()) {
      setState(new HalfOpenState());
    }
    return state.allow();
  }

  public void recordFailure() {
    if (state instanceof FailureAware currentState) {
      currentState.handleFailure(this);
    } else {
      System.out.println("Ignoring failure in current state: " + getState());
    }
  }

  public void recordSuccess() {
    if (state instanceof SuccessAware currentState) {
      currentState.handleSuccess(this);
    } else {
      System.out.println("Ignoring success in current state: " + getState());
    }
  }

  public int getFailureThreshold() {
    return failureThreshold;
  }

  public int getSuccessThreshold() {
    return successThreshold;
  }

  public Duration getOpenStateTimeout() {
    return openStateTimeout;
  }

  public String getState() {
    return state.getClass().getSimpleName();
  }

  public void setState(CircuitBreakerState newState) {
    System.out.println("🔁 Transitioned to " + newState.getClass().getSimpleName());
    this.state = newState;
  }
}
