package com.dev.tdd.corejava;

public class Bank {
    public Money reduce(Expression plus, String toCurrency) {
        return plus.reduce(toCurrency);
    }
}
