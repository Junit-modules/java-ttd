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

    @Test
    void testExpression() {
        // We are comparing Dollar against Franc. So it should not be equals
        Money money = new Money(10, "USD");
        Expression plus = money.plus(money);
        System.out.println(plus);
        Sum sum = (Sum) plus;
        assertEquals(Money.getDollar(10), sum.augmend);
        assertEquals(Money.getDollar(10), sum.addmend);
    }

    @Test
    void testBank() {
        // We are comparing Dollar against Franc. So it should not be equals
        Money money = new Money(10, "USD");
        Expression plus = money.plus(money);
        Bank bank = new Bank();
        Money reduced = bank.reduce(plus, "USD");
        assertEquals(new Money(20, "USD"), reduced);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(new Money(5, "USD"), new Money(2, "USD"));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(new Money(7, "USD"), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(new Money(1, "USD"), "USD");
        assertEquals(new Money(1, "USD"), result);
    }
}
