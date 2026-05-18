package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.Objects;

public record TransactionCustomer(String name, BigDecimal oldBalance, BigDecimal newBalance) {

    public TransactionCustomer {
        balanceCheck(oldBalance, "oldBalance");
        balanceCheck(newBalance,  "newBalance");
        nameCheck(name);
    }

    void balanceCheck(BigDecimal field, String fieldName) {
        if (Objects.isNull(field) || field.signum() < 0) {
            throw new IllegalArgumentException(
                    "The value of "+ fieldName +" is required and cannot be negative");
        }
    }
    void nameCheck(String field) {
        if (Objects.isNull(field) || field.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "The Customer name is required and cannot be empty");
        }
    }
}
