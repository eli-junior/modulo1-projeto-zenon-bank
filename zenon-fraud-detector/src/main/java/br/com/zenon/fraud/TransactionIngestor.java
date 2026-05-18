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


                Transaction t = parseTransaction(line);
                if (t == null) {
                    continue;
                }
                transactions.add(t);
            }
        }
        System.out.println("Fim");
        return transactions;
    }

    static boolean parseIntToBoolean(String key) {
        return key.equals("1");
    }

    static Transaction parseTransaction(String line) {
        try {

            String[] values = line.split(",");
            return new Transaction(
                    Integer.parseInt(values[0]),
                    TransactionType.valueOf(values[1]),
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
        } catch (Exception ex) {
            System.err.println("Erro ao processar linha: " + line + " | " + ex);
        }
        return null;
    }
}
