package main.java.low_code.circuit_breaker;

public final class ClosedState implements CircuitBreakerState, FailureAware, SuccessAware {

  private int failureCount = 0;

  @Override
  public boolean allow() {
    return true;
  }

  @Override
  public void handleFailure(CircuitBreaker context) {
    failureCount++;
    if (failureCount >= context.getFailureThreshold()) {
      context.setState(new OpenState(context.getOpenStateTimeout()));
    }
  }

  @Override
  public void handleSuccess(CircuitBreaker context) {
    failureCount = 0;
  }
}
