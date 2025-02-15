package org.example.services;

import org.example.statistics.FloatStatistic;
import org.example.statistics.IntegerStatistic;
import org.example.statistics.Statistic;
import org.example.statistics.StringStatistic;
import org.example.types.ValueType;

import java.util.EnumMap;
import java.util.Map;

public class StatisticService {
    private final Map<ValueType, Statistic<?>> statistics = new EnumMap<>(ValueType.class);

    @SuppressWarnings("unchecked")
    public <T> void addValueToStatistic(ValueType key, T value, boolean isFullStatistic) {
        Statistic<T> statistic = (Statistic<T>) statistics.get(key);

        if (statistic == null) {
            statistic = switch (key) {
                case INTEGER -> (Statistic<T>) new IntegerStatistic();
                case FLOAT -> (Statistic<T>) new FloatStatistic();
                case STRING -> (Statistic<T>) new StringStatistic();
            };
            statistics.put(key, statistic);
        }

        statistic.addToStatistic(value, isFullStatistic);
    }

    public void printStatistics(boolean isFullStatistic) {
        System.out.println("СТАТИСТИКА:\n");
        for (Statistic<?> stat : statistics.values()) {
            if (isFullStatistic) stat.showFullStatistic();
            else stat.showShortStatistic();
        }
    }
}
