package org.example.statistics;

import java.math.BigDecimal;

public class IntegerStatistic extends NumberStatistic<Long> {
    @Override
    public void showFullStatistic() {
        System.out.println("\nЦелые числа: ");
        super.showFullStatistic();
        BigDecimal roundedSum = sumOfElements.stripTrailingZeros();
        System.out.println("Сумма чисел: " + (roundedSum.scale() <= 0 ? roundedSum.toBigInteger() : roundedSum));
    }
}
