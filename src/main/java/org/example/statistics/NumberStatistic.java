package org.example.statistics;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
public abstract class NumberStatistic<T extends Number & Comparable<T>> implements Statistic<T> {

    protected long numOfElements;
    protected BigDecimal sumOfElements = BigDecimal.ZERO;
    protected T minOfElements;
    protected T maxOfElements;

    @Override
    public void addToStatistic(T value, boolean isFullStatistic) {
        numOfElements++;
        if (isFullStatistic) {
            sumOfElements = sumOfElements.add(BigDecimal.valueOf(value.doubleValue()));
            minOfElements = (minOfElements == null || value.compareTo(minOfElements) < 0) ? value : minOfElements;
            maxOfElements = (maxOfElements == null || value.compareTo(maxOfElements) > 0) ? value : maxOfElements;
        }
    }

    @Override
    public void showShortStatistic() {
        System.out.println("Количество чисел: " + numOfElements);
    }

    @Override
    public void showFullStatistic() {
        System.out.println("Количество чисел: " + numOfElements);
        System.out.println("Минимальное число: " + minOfElements);
        System.out.println("Максимальное число: " + maxOfElements);
        System.out.println("Среднее: " + sumOfElements.divide(BigDecimal.valueOf(numOfElements), 2, RoundingMode.HALF_UP));
    }
}
