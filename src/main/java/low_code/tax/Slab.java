package main.java.low_code.tax;

public class Slab {
    private double lowerBound;
    private double upperBound;
    private double taxPercentage;

    public Slab(double lowerBound, double upperBound, double taxPercentage) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.taxPercentage = taxPercentage;
    }

    public double getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(double lowerBound) {
        this.lowerBound = lowerBound;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }
}
