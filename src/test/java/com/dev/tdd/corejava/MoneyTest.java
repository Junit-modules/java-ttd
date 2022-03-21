package com.dev.tdd.corejava;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MoneyTest {

    @Test
    void testMultiplication() {
        //Dollar
        assertEquals(Money.getDollar(10), Money.getDollar(5).times(2));
        assertEquals(Money.getDollar(15), Money.getDollar(5).times(3));

        //Franc
        assertEquals(Money.getFranc(10), Money.getFranc(5).times(2));
        assertEquals(Money.getFranc(15), Money.getFranc(5).times(3));
    }

    @Test
    void testEqualitiesDollar() {
        //Dollar
        assertEquals(Money.getDollar(5), Money.getDollar(5));
        assertNotEquals(Money.getDollar(5), Money.getDollar(8));

        //Franc
        assertEquals(Money.getFranc(5), Money.getFranc(5));
        assertNotEquals(Money.getFranc(5), Money.getFranc(8));
    }

    //Common across
    @Test
    void compareMoney() {
        // We are comparing Dollar against Franc. So it should not be equals
        assertNotEquals(Money.getDollar(5), Money.getFranc(5));
    }

    @Test
    void testCurrency() {
        // We are comparing Dollar against Franc. So it should not be equals
        assertEquals("USD", Money.getDollar(1).getCurrency());
        assertEquals("CHG", Money.getFranc(1).getCurrency());
    }
}
