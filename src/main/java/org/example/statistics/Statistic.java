package org.example.statistics;

public interface Statistic<T> {
    void addToStatistic(T value, boolean isFullStatistic);

    void showShortStatistic();

    void showFullStatistic();
}
