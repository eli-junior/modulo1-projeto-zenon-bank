package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.Objects;

public record Transaction(int step, TransactionType type, BigDecimal amount, TransactionCustomer origin,
                          TransactionCustomer destination,
                          boolean isFraud,
                          boolean isFlaggedFraud) {

    public Transaction {
        stepCheck(step);
        amountCheck(amount);
        notNullFieldsCheck(type, "type");
        notNullFieldsCheck(origin, "origin");
        notNullFieldsCheck(destination, "destination");
    }

    private void notNullFieldsCheck(Object field, String fieldName) {
        if (Objects.isNull(field)) {
            throw new IllegalArgumentException(
                    "The value of " + fieldName + "is required (cannot be null)");

        }
    }

    private void stepCheck(int value) {
        if (value < 1) {
            throw new IllegalArgumentException(
                    "The value of step cannot be zero or negative");

        }
    }
    private void amountCheck(BigDecimal field) {
        if (Objects.isNull(field) || field.signum() < 0) {
            throw new IllegalArgumentException(
                    "The value of amount is required and cannot be zero or negative");

        }
    }
}
