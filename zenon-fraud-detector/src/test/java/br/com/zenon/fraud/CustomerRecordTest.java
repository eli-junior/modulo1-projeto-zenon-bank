package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRecordTest {
    @Test
    void shouldHaveACustomerClass() {
        assertNotNull(TransactionCustomer.class);
    }

    @Test
    void shouldContainAllCustomerFields() {
        String[] fields = {
                "name", "oldBalance", "newBalance"
        };

        assertAll(Arrays.stream(fields)
                .map(field -> (Executable) () -> assertDoesNotThrow(
                        () -> TransactionCustomer.class.getDeclaredField(field),
                        "Field not found: " + field
                ))
                .toArray(Executable[]::new)
        );
    }
    @Test
    void shouldCreateACustomerSuccessfully() {
        TransactionCustomer transactionCustomer = new TransactionCustomer(
                "C1231006815",
                new BigDecimal("170136.0"),
                new BigDecimal("160296.36")
        );

        assertEquals("C1231006815", transactionCustomer.name());
        assertEquals(new BigDecimal("170136.0"), transactionCustomer.oldBalance());
        assertEquals(new BigDecimal("160296.36"), transactionCustomer.newBalance());
    }

    @Test
    void shouldBeTwoClientsWithSameDataBeEquals() {
        TransactionCustomer c1 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);
        TransactionCustomer c2 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void shouldNotBeTwoClientsWithDifferentDataBeEquals() {
        TransactionCustomer c1 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);
        TransactionCustomer c2 = new TransactionCustomer("C999", BigDecimal.TEN, BigDecimal.ONE);

        assertNotEquals(c1, c2);
    }

}
