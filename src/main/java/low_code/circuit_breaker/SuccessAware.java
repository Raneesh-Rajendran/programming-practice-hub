package main.java.low_code.circuit_breaker;

public interface SuccessAware {
  void handleSuccess(CircuitBreaker context);
}
