package main.java.low_code.circuit_breaker;

public interface FailureAware {
    void handleFailure(CircuitBreaker context);
}
