package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTypeTest {

    @Test
    void shouldContainAllTransactionTypeValues() {
        List<String> expected = List.of("CASH_IN", "CASH_OUT", "DEBIT", "PAYMENT", "TRANSFER");

        List<String> actual = Arrays.stream(Transaction.TransactionTypes.values())
                .map(Enum::name)
                .toList();

        assertIterableEquals(expected, actual);
    }
}
