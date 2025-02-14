package org.example.statistics;

public class FloatStatistic extends NumberStatistic<Double> {
    @Override
    public void showFullStatistic() {
        System.out.println("\nВещественные числа: ");
        super.showFullStatistic();
        System.out.println("Сумма чисел: " + sumOfElements);
    }
}
