package org.example;

import org.example.statistics.IntegerStatistic;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class IntegerStatisticTest {
    private IntegerStatistic statistic;

    @Test
    public void testAddToStatistic_SingleElement() {
        statistic = new IntegerStatistic();
        statistic.addToStatistic((long) 5, true);
        statistic.showShortStatistic();
        statistic.showFullStatistic();
    }

    @Test
    public void testAddToStatistic_MultipleElements() {
        statistic = new IntegerStatistic();
        statistic.addToStatistic((long) 5, true);
        statistic.addToStatistic((long) 10, true);
        statistic.addToStatistic((long) 47, true);
        statistic.showFullStatistic();

        assertEquals(3, statistic.getNumOfElements());
        assertEquals(BigDecimal.valueOf(62.0), statistic.getSumOfElements());
        assertEquals(5, statistic.getMinOfElements());
        assertEquals(47, statistic.getMaxOfElements());
    }

    @Test
    public void testAddToStatistic_NoFullStatistic() {
        statistic = new IntegerStatistic();
        statistic.addToStatistic((long) 5, false);
        statistic.addToStatistic((long) 10, false);
        statistic.showFullStatistic();

        assertNull(statistic.getMinOfElements());
        assertNull(statistic.getMaxOfElements());
        assertEquals(BigDecimal.ZERO, statistic.getSumOfElements());
    }
}