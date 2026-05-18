package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;


import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRecordTest {
    int step = 1;
    TransactionType type = TransactionType.PAYMENT;
    BigDecimal amount = new BigDecimal("100.0");
    TransactionCustomer clienteA = new TransactionCustomer(
            "ClienteA",
            new BigDecimal("1000.0"),
            new BigDecimal("900.0")
    );
    TransactionCustomer clienteB = new TransactionCustomer(
            "ClienteB",
            new BigDecimal("500.0"),
            new BigDecimal("600.0")
    );
    boolean isFraud = true;
    boolean isFlaggedFraud = false;

    @Test
    void shouldHaveATransactionClass() {
        assertNotNull(Transaction.class);
    }

    @Test
    void shouldContainAllCSVFields() {
        String[] fields = {
                "step", "type", "amount", "origin", "destination", "isFraud", "isFlaggedFraud"
        };

        assertAll(Arrays.stream(fields)
                .map(field -> (Executable) () -> assertDoesNotThrow(
                        () -> Transaction.class.getDeclaredField(field),
                        "Field not found: " + field
                ))
                .toArray(Executable[]::new)
        );
    }

    @Test
    void shouldCreateATransactionSuccessfully() {
        Transaction t = new Transaction(step, type, amount, clienteA, clienteB, isFraud, isFlaggedFraud);


        assertEquals("ClienteA", t.origin().name());
        assertEquals(new BigDecimal("1000.0"), t.origin().oldBalance());
        assertEquals(new BigDecimal("900.0"), t.origin().newBalance());
        assertEquals("ClienteB", t.destination().name());
        assertEquals(new BigDecimal("500.0"), t.destination().oldBalance());
        assertEquals(new BigDecimal("600.0"), t.destination().newBalance());
    }

    @Test
    void shouldTransactionStepNegativeThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(-1, type, amount, clienteA, clienteB, isFraud, isFlaggedFraud)));
    }

    @Test
    void shouldTransactionStepEqualsZeroThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(0, type, amount, clienteA, clienteB, isFraud, isFlaggedFraud)));
    }
    @Test
    void shouldTransactionAmountNegativeThrowsIllegalArgumentException() {
        BigDecimal localAmount = new BigDecimal("-1");
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(step, type, localAmount, clienteA, clienteB, isFraud, isFlaggedFraud)));
    }

    @Test
    void shouldTransactionTypeNullThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(step, null, amount, clienteA, clienteB, isFraud, isFlaggedFraud)));
    }

    @Test
    void shouldTransactionAmountNullThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(step, type, null, clienteA, clienteB, isFraud, isFlaggedFraud)));
    }
    @Test
    void shouldTransactionOriginNullThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(step, type, amount, null, clienteB, isFraud, isFlaggedFraud)));
    }
    @Test
    void shouldTransactionDestinationNullThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, (() -> new Transaction(step, type, amount, clienteA, null, isFraud, isFlaggedFraud)));
    }
}
