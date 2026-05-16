package br.com.zenon.fraud;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

// PASSO 4 — Crie a classe Main antes de descomentar estes testes.
// Main deve instanciar as duas transações e imprimi-las no console.
class MainTest {

    /*
    private final ByteArrayOutputStream outputCapturado = new ByteArrayOutputStream();
    private final PrintStream saidaOriginal = System.out;

    @BeforeEach
    void redirecionarSaida() {
        System.setOut(new PrintStream(outputCapturado));
    }

    @AfterEach
    void restaurarSaida() {
        System.setOut(saidaOriginal);
    }

    @Test
    void deveImprimirAsDuasTransacoesNoConsole() {
        Main.main(new String[]{});

        String saida = outputCapturado.toString();

        // Verifica dados da transação 1
        assertTrue(saida.contains("PAYMENT"), "Deveria conter o tipo PAYMENT");
        assertTrue(saida.contains("C1231006815"), "Deveria conter o nome de origem da transação 1");
        assertTrue(saida.contains("M1979787155"), "Deveria conter o nome de destino da transação 1");

        // Verifica dados da transação 2
        assertTrue(saida.contains("CASH_OUT"), "Deveria conter o tipo CASH_OUT");
        assertTrue(saida.contains("C1280323807"), "Deveria conter o nome de origem da transação 2");
        assertTrue(saida.contains("C873221189"), "Deveria conter o nome de destino da transação 2");
    }

    @Test
    void deveImprimirInformacaoDeTransacaoFraudulenta() {
        Main.main(new String[]{});

        String saida = outputCapturado.toString();

        // A transação 2 é fraude — o valor true deve aparecer na saída
        assertTrue(saida.contains("true"), "Deveria indicar que a transação 2 é fraude");
    }
    */
}
