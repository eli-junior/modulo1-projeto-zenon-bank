package br.com.zenon.fraud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TransactionCustomerRecordTest {
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
    void shouldBeTwoCustomersWithSameDataBeEquals() {
        TransactionCustomer c1 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);
        TransactionCustomer c2 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void shouldNotBeTwoCustomersWithDifferentDataBeEquals() {
        TransactionCustomer c1 = new TransactionCustomer("C123", BigDecimal.TEN, BigDecimal.ONE);
        TransactionCustomer c2 = new TransactionCustomer("C999", BigDecimal.TEN, BigDecimal.ONE);

        assertNotEquals(c1, c2);
    }
    @Test
    void shouldTransactionCustomerOldBalanceNegativeThrowsIllegalArgumentException() {
        BigDecimal negativeValue = new BigDecimal("-0.01");
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("Fulano", negativeValue, value)));
    }
    @Test
    void shouldTransactionCustomerNewBalanceNegativeThrowsIllegalArgumentException() {
        BigDecimal negativeValue = new BigDecimal("-0.01");
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("Fulano", value, negativeValue)));
    }
    @Test
    void shouldTransactionCustomerEmptyNameThrowsIllegalArgumentException() {
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("   ", value, value)));
    }
    @Test
    void shouldTransactionCustomerBlankNameThrowsIllegalArgumentException() {
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("", value, value)));
    }

    @Test
    void shouldTransactionCustomerOldBalanceNullThrowsIllegalArgumentException() {
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("Tobias", null, value)));
    }
    @Test
    void shouldTransactionCustomerNewBalanceNullThrowsIllegalArgumentException() {
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer("Tobias", value, null)));
    }
    @Test
    void shouldTransactionCustomerNameNullThrowsIllegalArgumentException() {
        BigDecimal value = new BigDecimal("1");
        assertThrows(IllegalArgumentException.class, (() -> new TransactionCustomer(null, value, value)));
    }

}
