package com.dev.tdd.corejava;

public class Sum implements Expression{

    final Money augmend;
    final Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    public Money reduce(String toCurrency) {
        int amount = this.augmend.amount + this.addmend.amount;
        return new Money(amount, toCurrency);
    }
}
