package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {
    @Test
    void shouldHaveExistsATransactionTypeEnumClass() {
        assertNotNull(Transaction.TransactionTypes.class);
    }

    @Test
    void shouldContainAllTransactionTypeValues() {

        String[] expectedValues = {"CASH_IN", "CASH_OUT", "DEBIT", "PAYMENT", "TRANSFER"};

        List<String> actualValues = java.util.Arrays.stream(Transaction.TransactionTypes.values())
                .map(Enum::name)
                .toList();

        assertAll(
                () -> assertTrue(actualValues.contains(expectedValues[0])),
                () -> assertTrue(actualValues.contains(expectedValues[1])),
                () -> assertTrue(actualValues.contains(expectedValues[2])),
                () -> assertTrue(actualValues.contains(expectedValues[3])),
                () -> assertTrue(actualValues.contains(expectedValues[4]))
        );
    }
}
