package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

// PASSO 2 — Crie o record Customer antes de descomentar estes testes.
// Customer encapsula os campos name, oldBalance e newBalance
// (tanto para origem quanto para destino).
class CustomerTest {

    /*
    @Test
    void deveCriarClienteComOsCamposCorretos() {
        Customer customer = new Customer(
                "C1231006815",
                new BigDecimal("170136.0"),
                new BigDecimal("160296.36")
        );

        assertEquals("C1231006815", customer.name());
        assertEquals(new BigDecimal("170136.0"), customer.oldBalance());
        assertEquals(new BigDecimal("160296.36"), customer.newBalance());
    }

    @Test
    void doisClientesComMesmosDadosDevemSerIguais() {
        Customer c1 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);
        Customer c2 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);

        // Records implementam equals/hashCode automaticamente
        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void clientesComNomesDiferentesDevemSerDiferentes() {
        Customer c1 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);
        Customer c2 = new Customer("C999", BigDecimal.TEN, BigDecimal.ONE);

        assertNotEquals(c1, c2);
    }
    */
}
