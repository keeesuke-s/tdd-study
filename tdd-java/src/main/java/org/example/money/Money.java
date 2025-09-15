package org.example.money;

class Money implements Expression {
    protected int amount;
    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    // factory methods
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    String currency() {
        return this.currency;
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier,currency);
    }

    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && this.currency.equals(money.currency);
    }

    Expression plus(Money addend) {
        return new Sum(this , addend);
    }

    public Money reduce(String to) {
        return this;
    }
}
