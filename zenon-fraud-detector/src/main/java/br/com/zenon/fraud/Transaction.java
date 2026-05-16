package br.com.zenon.fraud;

import java.math.BigDecimal;

public record Transaction(int step, TransactionTypes type, BigDecimal amount, Customer origin,
                          Customer destination,
                          boolean isFraud,
                          boolean isFlaggedFraud) {

    public enum TransactionTypes {
        CASH_IN, CASH_OUT, DEBIT, PAYMENT, TRANSFER
    }
}
