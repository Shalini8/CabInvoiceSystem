package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {

    private final double averageFare;
    private final int numberOfRides;
    private final double totalFare;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InvoiceSummary)) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.averageFare, averageFare) == 0 && numberOfRides == that.numberOfRides && Double.compare(that.totalFare, totalFare) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(averageFare, numberOfRides, totalFare);
    }

    public InvoiceSummary(int numberOfRides, double totalFare) {
        this.numberOfRides = numberOfRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numberOfRides;
    }
}
