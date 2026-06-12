package main.java.low_code.tax;

import java.util.List;

public class LoopingTaxStrategy implements TaxStrategy {

  private final List<Slab> slabs;

  public LoopingTaxStrategy(List<Slab> slabs) {
    this.slabs = slabs;
  }

  @Override
  public double calculateTax(double income) {
    double tax = 0;

    for (Slab slab : slabs) {
      if (slab.getUpperBound() != -1 && income > slab.getUpperBound()) {
        tax += (slab.getUpperBound() - slab.getLowerBound()) * (slab.getTaxPercentage() / 100);
      } else {
        tax += (income - slab.getLowerBound()) * (slab.getTaxPercentage() / 100);
        break;
      }
    }

    return tax;
  }
}
