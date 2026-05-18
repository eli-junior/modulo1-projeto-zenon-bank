package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;

class TransactionIngestorTest {

    @Test
    void shouldProcessAEmptyFile() {
        TransactionIngestor ti = new TransactionIngestor();
        try{
            var lines = ti.Ingestor("./src/test/java/br/com/zenon/fraud/dataTest/empty_list.csv", 10);
            assertEquals(0, lines.size());
        } catch (Exception ex) {
            throw  new RuntimeException(ex);
        }
    }

    @Test
    void shouldProcessAFileTotallyInformingSizeSuperior() {
        TransactionIngestor ti = new TransactionIngestor();
        try{
            var lines = ti.Ingestor("./src/test/java/br/com/zenon/fraud/dataTest/sample.csv", 1000);
            assertEquals(25, lines.size());
        } catch (Exception ex) {
            throw  new RuntimeException(ex);
        }
    }
    @Test
    void shouldSkipEightLinesWithErrors() {
        TransactionIngestor ti = new TransactionIngestor();
        try{
            var lines = ti.Ingestor("./src/test/java/br/com/zenon/fraud/dataTest/sample_w_errors.csv", 1000);
            assertEquals(8, lines.size());
        } catch (Exception ex) {
            throw  new RuntimeException(ex);
        }
    }

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
                TransactionType.PAYMENT,
                new BigDecimal("9839.64"),
                new TransactionCustomer(
                        "C1231006815",
                        new BigDecimal("170136.0"),
                        new BigDecimal("160296.36")
                ),
                new TransactionCustomer(
                        "M1979787155",
                        new BigDecimal("0.0"),
                        new BigDecimal("0.0")
                ),
                false,
                false
        );
        assertEquals(TransactionIngestor.parseTransaction(entry), expected);
    }
}