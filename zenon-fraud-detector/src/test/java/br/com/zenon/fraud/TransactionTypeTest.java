package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// PASSO 1 — Crie o enum TransactionType antes de rodar este teste.
class TransactionTypeTest {

    @Test
    void deveTerExatamenteCincoValores() {
        assertEquals(5, TransactionType.values().length);
    }

    /*
    @Test
    void deveTerOsValoresEsperados() {
        assertNotNull(TransactionType.valueOf("CASH_IN"));
        assertNotNull(TransactionType.valueOf("CASH_OUT"));
        assertNotNull(TransactionType.valueOf("DEBIT"));
        assertNotNull(TransactionType.valueOf("PAYMENT"));
        assertNotNull(TransactionType.valueOf("TRANSFER"));
    }

    @Test
    void deveLancarExcecaoParaValorInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> TransactionType.valueOf("PIX"));
    }
    */
}
