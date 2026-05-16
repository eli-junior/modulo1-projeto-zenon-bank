package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class TransactionRecordTest {

    @Test
    void shouldHaveATransactionClass() {
        assertNotNull(Transaction.class);
    }

    @Test
    void shouldContainAllCSVFields() {
        String[] fields = {
                "step", "type", "amount", "origin", "recipient", "isFraud", "isFlaggedFraud"
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
        var step = 1;
        var type = TransactionType.PAYMENT;
        var amount = new BigDecimal("100.0");
        var nameOrig = "ClienteA";
        var oldbalanceOrg = new BigDecimal("1000.0");
        var newbalanceOrig = new BigDecimal("900.0");
        var origin = new TransactionCustomer(nameOrig, oldbalanceOrg, newbalanceOrig);
        var nameDest = "ClienteB";
        var oldbalanceDest = new BigDecimal("500.0");
        var newbalanceDest = new BigDecimal("600.0");
        var destination = new TransactionCustomer(nameDest, oldbalanceDest, newbalanceDest);
        var isFraud = true;
        var isFlaggedFraud = false;

        Transaction transaction = new Transaction(
            step, type, amount, origin, destination, isFraud, isFlaggedFraud
        );

        assertEquals("ClienteA", transaction.origin().name());
        assertEquals(new BigDecimal("1000.0"), transaction.origin().oldBalance());
        assertEquals(new BigDecimal("900.0"), transaction.origin().newBalance());
        assertEquals("ClienteB", transaction.recipient().name());
        assertEquals(new BigDecimal("500.0"), transaction.recipient().oldBalance());
        assertEquals(new BigDecimal("600.0"), transaction.recipient().newBalance());
    }
}
