package br.com.zenon.fraud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TransactionIngestor {
    public List<Transaction> Ingestor(String filename, int size) throws Exception {
        Path path = Paths.get(filename);

        ArrayList<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path.toFile()))) {
            for (int i = 0; i <= size; i++) {
                System.out.println("Processando linha " + i);
                String line = br.readLine();
                System.out.println(line);
                if (i == 0) {
                    System.out.println("Ignorando cabecalho!");
                    continue;
                }
                if (line == null) {
                    break;
                }


                Transaction t = LineToTransaction(line);
                transactions.add(t);
            }
        }
        System.out.println("Fim");
        return transactions;
    }

    public static boolean parseIntToBoolean(String key) {
        return key.equals("1");
    }

    public static Transaction LineToTransaction(String line) {
        String[] values = line.split(",");
        return new Transaction(
                Integer.parseInt(values[0]),
                Transaction.TransactionTypes.valueOf(values[1]),
                new BigDecimal(values[2]),
                new TransactionCustomer(
                    values[3],
                    new BigDecimal(values[4]),
                    new BigDecimal(values[5])
                ),
                new TransactionCustomer(
                    values[6],
                    new BigDecimal(values[7]),
                    new BigDecimal(values[8])
                ),
                parseIntToBoolean(values[9]),
                parseIntToBoolean(values[10])
        );
    }
}
