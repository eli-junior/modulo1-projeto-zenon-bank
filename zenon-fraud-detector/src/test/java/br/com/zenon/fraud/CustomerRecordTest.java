package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRecordTest {
    @Test
    void shouldHaveACustomerClass() {
        assertNotNull(Customer.class);
    }

    @Test
    void shouldContainAllCustomerFields() {
        String[] fields = {
                "name", "oldBalance", "newBalance"
        };

        assertAll(Arrays.stream(fields)
                .map(field -> (Executable) () -> assertDoesNotThrow(
                        () -> Customer.class.getDeclaredField(field),
                        "Field not found: " + field
                ))
                .toArray(Executable[]::new)
        );
    }
    @Test
    void shouldCreateACustomerSuccessfully() {
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
    void ShouldBeTwoClientsWithSameDataEquals() {
        Customer c1 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);
        Customer c2 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void ShouldNotBeTwoClientsWithDifferentDataEquals() {
        Customer c1 = new Customer("C123", BigDecimal.TEN, BigDecimal.ONE);
        Customer c2 = new Customer("C999", BigDecimal.TEN, BigDecimal.ONE);

        assertNotEquals(c1, c2);
    }

}
