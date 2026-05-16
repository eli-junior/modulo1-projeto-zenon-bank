package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TransactionIngestorTest {
    @Test
    void shouldHaveACustomerClass() {
        assertNotNull(TransactionIngestor.class);
    }

    @Test
    void shouldReturnTrueIfKeyIsOne() {
        assertTrue(TransactionIngestor.parseIntToBoolean("1"));
    }

    @Test
    void shouldReturnFalseIfKeyIsZero() {
        assertFalse(TransactionIngestor.parseIntToBoolean("0"));
    }

    @Test
    void shouldTransformALineFromFileIntoTransaction() {
        String entry = "1,PAYMENT,9839.64,C1231006815,170136.0,160296.36,M1979787155,0.0,0.0,0,0\n";
        Transaction expected = new Transaction(
                1,
                Transaction.TransactionTypes.PAYMENT,
                new BigDecimal("9839.64"),
                new Customer(
                        "C1231006815",
                        new BigDecimal("170136.0"),
                        new BigDecimal("160296.36")
                ),
                new Customer(
                        "M1979787155",
                        new BigDecimal("0.0"),
                        new BigDecimal("0.0")
                ),
                false,
                false
        );
        assertEquals(TransactionIngestor.LineToTransaction(entry), expected);
    }
}