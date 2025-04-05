package main.java.low_code.circuit_breaker;

import java.time.Duration;

public class CircuitBreakerService {

  public static void main(String[] args) throws InterruptedException {
    CircuitBreaker circuitBreaker =
        new CircuitBreaker(
            3, // failure threshold
            2, // success threshold
            Duration.ofSeconds(5) // open state timeout
            );

    for (int i = 1; i <= 30; i++) {
      System.out.println("\n Request #" + i);

      if (!circuitBreaker.allowRequest()) {
        System.out.println("Request blocked - Circuit is OPEN or not allowed.");
      } else {
        try {
          simulateExternalCall();
          System.out.println("Service call succeeded.");
          circuitBreaker.recordSuccess();
        } catch (Exception e) {
          System.out.println("Service call failed: " + e.getMessage());
          circuitBreaker.recordFailure();
        }
      }

      System.out.println("Current Circuit Breaker State: " + circuitBreaker.getState());
      Thread.sleep(1000); // simulate delay between requests
    }
  }

  private static void simulateExternalCall() throws Exception {
    if (Math.random() < 0.5) { // ~50% failure rate
      throw new Exception("Simulated service failure");
    }
  }
}
