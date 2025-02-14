package org.example.services;

import org.example.statistics.FloatStatistic;
import org.example.statistics.IntegerStatistic;
import org.example.statistics.Statistic;
import org.example.statistics.StringStatistic;

import java.util.HashMap;
import java.util.Map;

public class StatisticService {
    private final Map<String, Statistic<?>> statistics = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> void addValueToStatistic(String key, T value, boolean isFullStatistic) {
        Statistic<T> statistic = (Statistic<T>) statistics.get(key);

        if (statistic == null) {
            if (value instanceof Long) {
                statistic = (Statistic<T>) new IntegerStatistic();
            } else if (value instanceof Double) {
                statistic = (Statistic<T>) new FloatStatistic();
            } else if (value instanceof String) {
                statistic = (Statistic<T>) new StringStatistic();
            }
            statistics.put(key, statistic);
        }

        if (statistic != null) {
            statistic.addToStatistic(value, isFullStatistic);
        }
    }

    public void printStatistics(boolean isFullStatistic) {
        System.out.println("СТАТИСТИКА:\n");
        for (Statistic<?> stat : statistics.values()) {
            if (isFullStatistic) stat.showFullStatistic();
            else stat.showShortStatistic();
        }
    }
}
