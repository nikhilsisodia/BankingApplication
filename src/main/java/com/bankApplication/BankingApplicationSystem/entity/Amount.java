package com.bankApplication.BankingApplicationSystem.entity;

import com.bankApplication.BankingApplicationSystem.exception.AmountParserException;

import java.math.BigInteger;

public class Amount {

    private BigInteger cents;

    public Amount() {
        this.cents = BigInteger.ZERO;
    }

    public Amount(BigInteger cents) {
        this.cents = cents;
    }

    @Override
    public String toString() {
        BigInteger dollars = this.cents.divide(BigInteger.valueOf(100)) ;
        BigInteger cents = this.cents.mod(BigInteger.valueOf(100));
        if(dollars.equals(BigInteger.ZERO) && cents.equals(BigInteger.ZERO))
            return "0";

        String amount = "";
        if(!dollars.equals(BigInteger.ZERO))
            amount += dollars + "D";
        if(!cents.equals(BigInteger.ZERO)) {
            if(!amount.equals(""))
                amount += " ";
            amount += cents + "C";
        }
        return amount;
    }

    private void setAmount(BigInteger dollars, BigInteger cents) {
        this.cents = dollars.multiply(BigInteger.valueOf(100)).add(cents);
    }

    public Amount(BigInteger dollars, BigInteger cents) {
        this.setAmount(dollars, cents);
    }

    private BigInteger parseToken(String token) {
        return new BigInteger(token.substring(0, token.length() - 1));
    }

    public Amount(String amount) throws AmountParserException {
        String[] tokens = amount.trim().split(" ");
        if(
            (tokens.length <= 0 || tokens.length > 2) ||
            (tokens.length == 2 && (!tokens[0].endsWith("D") || !tokens[1].endsWith("C"))) ||
            (tokens.length == 1 && !tokens[0].endsWith("D") && !tokens[0].endsWith("C"))
        ) {
            throw new AmountParserException("Input must be of the form xD yC");
        }
        if(tokens.length == 2) {
            this.setAmount(this.parseToken(tokens[0]), this.parseToken(tokens[1]));
        }
        else if(tokens[0].endsWith("D")) {
            this.setAmount(this.parseToken(tokens[0]), BigInteger.ZERO);
        } else {
            this.setAmount(BigInteger.ZERO, this.parseToken(tokens[0]));
        }
    }

    public Amount add(Amount other) {
        return new Amount(this.cents.add(other.cents));
    }

    public Amount subtract(Amount other) {
        return new Amount(this.cents.subtract(other.cents));
    }

    public BigInteger getCents() {
        return this.cents;
    }
}
