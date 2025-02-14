package org.example;

import org.example.statistics.StringStatistic;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringStatisticTest {
    private StringStatistic statistic;

    @Test
    public void testAddToStatistic_SingleElement() {
        statistic = new StringStatistic();
        statistic.addToStatistic("hello", true);
        statistic.showShortStatistic();
        statistic.showFullStatistic();
    }

    @Test
    public void testAddToStatistic_MultipleElements() {
        statistic = new StringStatistic();
        statistic.addToStatistic("hello", true);
        statistic.addToStatistic("world", true);
        statistic.addToStatistic("Java", true);
        statistic.showFullStatistic();

        assertEquals(3, statistic.getNumOfElements());
        assertEquals(4, statistic.getMinLength());
        assertEquals(5, statistic.getMaxLength());
    }

    @Test
    public void testAddToStatistic_NoFullStatistic() {
        statistic = new StringStatistic();
        statistic.addToStatistic("hello", false);
        statistic.addToStatistic("world", false);
        statistic.showFullStatistic();

        assertEquals(Long.MAX_VALUE, statistic.getMinLength());
        assertEquals(Long.MIN_VALUE, statistic.getMaxLength());
    }

    @Test
    public void testAddToStatistic_EmptyString() {
        statistic = new StringStatistic();
        statistic.addToStatistic("", true);
        statistic.showFullStatistic();

        assertEquals(1, statistic.getNumOfElements());
        assertEquals(0, statistic.getMinLength());
        assertEquals(0, statistic.getMaxLength());
    }
}