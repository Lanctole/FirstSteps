package org.example.statistics;

import lombok.Getter;

@Getter
public class StringStatistic implements Statistic<String> {

    private long numOfElements;
    private long minLength = Long.MAX_VALUE;
    private long maxLength = Long.MIN_VALUE;

    @Override
    public void addToStatistic(String value, boolean isFullStatistic) {
        numOfElements++;
        if (isFullStatistic) {
            long length = value.length();
            minLength = Math.min(minLength, length);
            maxLength = Math.max(maxLength, length);
        }
    }

    @Override
    public void showShortStatistic() {
        System.out.println("Количество строк: " + numOfElements);
    }

    @Override
    public void showFullStatistic() {
        System.out.println("Количество строк: " + numOfElements);
        System.out.println("Длина самой короткой строки: " + minLength);
        System.out.println("Длина самой длинной строки: " + maxLength);
    }
}
