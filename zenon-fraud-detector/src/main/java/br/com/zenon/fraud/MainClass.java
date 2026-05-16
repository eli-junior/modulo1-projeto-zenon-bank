import br.com.zenon.fraud.Customer;
import br.com.zenon.fraud.Transaction;

import java.math.BigDecimal;

static void main() {

    Customer C1231006815 = new Customer(
            "C1231006815",
            new BigDecimal("170136.0"),
            new BigDecimal("160296.36")

    );

    Customer M1979787155 = new Customer(
            "M1979787155",
            new BigDecimal("0.0"),
            new BigDecimal("0.0")

    );

    Transaction transaction1 = new Transaction(
            1L,
            Transaction.TransactionTypes.PAYMENT,
            new BigDecimal("9839.64"),
            C1231006815,
            M1979787155,
            false,
            false
            );

    Customer C1280323807 = new Customer(
            "C1280323807",
            new BigDecimal("850002.52"),
            new BigDecimal("0.0")


    );

    Customer C873221189 = new Customer(
            "C873221189",
            new BigDecimal(6510099.11),
            new BigDecimal(7360101.63)
    );

    Transaction transaction2 = new Transaction(
            743L,
            Transaction.TransactionTypes.CASH_OUT,
            new BigDecimal("850002.52"),
            C1280323807,
            C873221189,
            true,
            false
    );

    IO.println("Transacao 1:" +
            "\n\tstep: " + transaction1.step() +
            "\n\ttype: " + transaction1.type() +
            "\n\tamount: " + transaction1.amount() +
            "\n\torigin: " + transaction1.origin() +
            "\n\tdestination: " + transaction1.destination() +
            "\n\tisFraud: " + transaction1.isFraud() +
            "\n\tisFlaggedFraud: " + transaction1.isFlaggedFraud()
    );
    IO.println("Transacao 2:" +
            "\n\tstep: " + transaction2.step() +
            "\n\ttype: " + transaction2.type() +
            "\n\tamount: " + transaction2.amount() +
            "\n\torigin: " + transaction2.origin() +
            "\n\tdestination: " + transaction2.destination() +
            "\n\tisFraud: " + transaction2.isFraud() +
            "\n\tisFlaggedFraud: " + transaction2.isFlaggedFraud()
    );

}