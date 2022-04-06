package com.dev.tdd.corejava;

import java.util.Objects;

public class Money implements Expression{

    protected final int amount;

    protected final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int times) {
        return new Money(this.amount * times, this.currency);
    }

    public static Money getDollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money getFranc(int amount){
        return new Money(amount, "CHG");
    }

    public String getCurrency() {
        return this.currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //it will fail when we compare Dollar and Franc, since it is using getClass()
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return this.amount == money.amount && this.currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }

    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(String toCurrency) {
        return this;
    }
}
