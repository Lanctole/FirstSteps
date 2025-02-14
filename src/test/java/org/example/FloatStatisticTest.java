package org.example;

import org.example.statistics.FloatStatistic;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class FloatStatisticTest {
    private FloatStatistic statistic;

    @Test
    public void testAddToStatistic_SingleElement() {
        statistic = new FloatStatistic();
        statistic.addToStatistic(5.0, true);
        statistic.showShortStatistic();
        statistic.showFullStatistic();
    }

    @Test
    public void testAddToStatistic_MultipleElements() {
        statistic = new FloatStatistic();
        statistic.addToStatistic(5.5, true);
        statistic.addToStatistic(10.0, true);
        statistic.addToStatistic(47.7, true);
        statistic.showFullStatistic();

        assertEquals(3, statistic.getNumOfElements());
        assertEquals(BigDecimal.valueOf(63.2), statistic.getSumOfElements());
        assertEquals(5.5, statistic.getMinOfElements());
        assertEquals(47.7, statistic.getMaxOfElements());
    }

    @Test
    public void testAddToStatistic_NoFullStatistic() {
        statistic = new FloatStatistic();
        statistic.addToStatistic(5.0, false);
        statistic.addToStatistic(10.0, false);
        statistic.showFullStatistic();

        assertNull(statistic.getMinOfElements());
        assertNull(statistic.getMaxOfElements());
        assertEquals(BigDecimal.ZERO, statistic.getSumOfElements());
    }
}