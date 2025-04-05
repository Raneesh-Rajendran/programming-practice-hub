package main.java.low_code.circuit_breaker;

public final class HalfOpenState implements CircuitBreakerState, FailureAware, SuccessAware {

  private int successCount = 0;

  @Override
  public boolean allow() {
    return true;
  }

  @Override
  public void handleSuccess(CircuitBreaker context) {
    successCount++;
    if (successCount >= context.getSuccessThreshold()) {
      context.setState(new ClosedState());
    }
  }

  @Override
  public void handleFailure(CircuitBreaker context) {
    context.setState(new OpenState(context.getOpenStateTimeout()));
  }
}
