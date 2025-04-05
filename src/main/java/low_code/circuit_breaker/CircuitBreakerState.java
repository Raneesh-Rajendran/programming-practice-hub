package main.java.low_code.circuit_breaker;

/*
 * Marker Interface for the state
 */
public sealed interface CircuitBreakerState permits ClosedState, OpenState, HalfOpenState {
  boolean allow();
}
