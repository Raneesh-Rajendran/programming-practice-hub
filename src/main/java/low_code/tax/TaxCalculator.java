package main.java.low_code.tax;

import java.util.List;

public class TaxCalculator {

  private TaxStrategy strategy;

  public TaxCalculator(TaxStrategy strategy) {
    this.strategy = strategy;
  }

  public double calculateTax(double income) {
    return strategy.calculateTax(income);
  }

  public static void main(String[] args) {

    Slab slab1 = new Slab(0, 100, 0);
    Slab slab2 = new Slab(100, 200, 10);
    Slab slab3 = new Slab(200, 400, 20);
    Slab slab4 = new Slab(400, -1, 25);
    LoopingTaxStrategy taxStrategy = new LoopingTaxStrategy(List.of(slab1, slab2, slab3, slab4));

    TaxCalculator taxCalculator = new TaxCalculator(taxStrategy);

    System.out.println(taxCalculator.calculateTax(350));
  }
}
