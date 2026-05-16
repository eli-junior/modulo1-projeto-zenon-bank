package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

// PASSO 3 — Crie o record Transaction antes de descomentar estes testes.
// Transaction usa TransactionType e Customer como tipos dos seus campos.
class TransactionTest {

    /*
    @Test
    void deveCriarTransacaoComTodosOsCampos() {
        Customer origem = new Customer(
                "C1231006815",
                new BigDecimal("170136.0"),
                new BigDecimal("160296.36")
        );
        Customer destino = new Customer(
                "M1979787155",
                BigDecimal.ZERO,
                BigDecimal.ZERO
        );

        Transaction transaction = new Transaction(
                1,
                TransactionType.PAYMENT,
                new BigDecimal("9839.64"),
                origem,
                destino,
                false,
                false
        );

        assertEquals(1, transaction.step());
        assertEquals(TransactionType.PAYMENT, transaction.type());
        assertEquals(new BigDecimal("9839.64"), transaction.amount());
        assertEquals(origem, transaction.origin());
        assertEquals(destino, transaction.destination());
        assertFalse(transaction.isFraud());
        assertFalse(transaction.isFlaggedFraud());
    }

    @Test
    void deveRepresentarTransacao1Corretamente() {
        Customer origem = new Customer(
                "C1231006815",
                new BigDecimal("170136.0"),
                new BigDecimal("160296.36")
        );
        Customer destino = new Customer(
                "M1979787155",
                BigDecimal.ZERO,
                BigDecimal.ZERO
        );

        Transaction t1 = new Transaction(
                1,
                TransactionType.PAYMENT,
                new BigDecimal("9839.64"),
                origem,
                destino,
                false,
                false
        );

        assertEquals(1, t1.step());
        assertEquals(TransactionType.PAYMENT, t1.type());
        assertEquals(new BigDecimal("9839.64"), t1.amount());
        assertEquals("C1231006815", t1.origin().name());
        assertEquals(new BigDecimal("170136.0"), t1.origin().oldBalance());
        assertEquals(new BigDecimal("160296.36"), t1.origin().newBalance());
        assertEquals("M1979787155", t1.destination().name());
        assertEquals(BigDecimal.ZERO, t1.destination().oldBalance());
        assertEquals(BigDecimal.ZERO, t1.destination().newBalance());
        assertFalse(t1.isFraud());
        assertFalse(t1.isFlaggedFraud());
    }

    @Test
    void deveRepresentarTransacao2Corretamente() {
        Customer origem = new Customer(
                "C1280323807",
                new BigDecimal("850002.52"),
                BigDecimal.ZERO
        );
        Customer destino = new Customer(
                "C873221189",
                new BigDecimal("6510099.11"),
                new BigDecimal("7360101.63")
        );

        Transaction t2 = new Transaction(
                743,
                TransactionType.CASH_OUT,
                new BigDecimal("850002.52"),
                origem,
                destino,
                true,
                false
        );

        assertEquals(743, t2.step());
        assertEquals(TransactionType.CASH_OUT, t2.type());
        assertEquals(new BigDecimal("850002.52"), t2.amount());
        assertEquals("C1280323807", t2.origin().name());
        assertEquals(BigDecimal.ZERO, t2.origin().newBalance());
        assertEquals("C873221189", t2.destination().name());
        assertEquals(new BigDecimal("6510099.11"), t2.destination().oldBalance());
        assertEquals(new BigDecimal("7360101.63"), t2.destination().newBalance());
        assertTrue(t2.isFraud());
        assertFalse(t2.isFlaggedFraud());
    }

    @Test
    void doisRecordsComMesmosDadosDevemSerIguais() {
        Customer origem = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);
        Customer destino = new Customer("C999", BigDecimal.ONE, BigDecimal.TEN);

        Transaction t1 = new Transaction(1, TransactionType.DEBIT,
                new BigDecimal("100.0"), origem, destino, false, false);
        Transaction t2 = new Transaction(1, TransactionType.DEBIT,
                new BigDecimal("100.0"), origem, destino, false, false);

        assertEquals(t1, t2);
    }
    */
}
