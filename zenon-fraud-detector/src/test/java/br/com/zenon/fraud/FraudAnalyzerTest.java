package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FraudAnalyzerTest {

    List<Transaction> transactionsLoader() {
        TransactionIngestor ti = new TransactionIngestor();
        try{
            return ti.Ingestor("./src/test/java/br/com/zenon/fraud/dataTest/sample.csv", 25);

        } catch (Exception ex) {
            System.err.println("Error loading transactions: " + ex.getMessage());
        }
        return null;
    }

    @Test
    void shouldFraudCounterCounts5Items() {
        var lines = transactionsLoader();
        assertEquals(5, FraudAnalyzer.fraudCounter(lines).size());

    }
    @Test
    void shouldBring3MostFraudAmounts() {
        var lines = transactionsLoader();
        var result = FraudAnalyzer.topFrauds(lines, 3);
        assertEquals("3099.97", result.get(0));
        assertEquals("1373.43", result.get(1));
        assertEquals("671.64", result.get(2));

    }
    @Test
    void shouldBring5MostFraudAmounts() {
        var lines = transactionsLoader();
        var result = FraudAnalyzer.suspectsClientsNameList(lines, 3);
        assertEquals("C249177573", result.get(0));
        assertEquals("C20804602", result.get(1));
        assertEquals("C2033524545", result.get(2));
    }

    @Test
    void shouldBringTotalAmountFrauds() {
        var lines = transactionsLoader();
        var result = FraudAnalyzer.totalFraudsAmount(lines);
        assertEquals(new BigDecimal("5507.04"), result);
    }
    @Test
    void shouldCountFraudsByType() {
        var lines = transactionsLoader();
        var expected = new HashMap<TransactionType, Long>();
        expected.put(TransactionType.PAYMENT, 3L);
        expected.put(TransactionType.TRANSFER, 1L);
        expected.put(TransactionType.CASH_OUT, 1L);
        var result = FraudAnalyzer.countFraudsByType(lines);
        assertEquals(expected, result);
    }
}