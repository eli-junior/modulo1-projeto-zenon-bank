import br.com.zenon.fraud.FraudAnalyzer;
import br.com.zenon.fraud.TransactionIngestor;
import br.com.zenon.fraud.TransactionType;

import java.util.Map;

void main() {
    try {
        TransactionIngestor ingestor = new TransactionIngestor();
        var items = ingestor.Ingestor("zenon-fraud-detector/data/PS_20174392719_1491204439457_log.csv", 50_000);
        System.out.println("\n\n---------Relatorio--------------\n\n");
        items.stream().limit(10).forEach(System.out::println);
        var fraudsList = FraudAnalyzer.fraudCounter(items);

        System.out.println("1. Total de Fraudes: "  + fraudsList.size());

        var topFrauds = FraudAnalyzer.topFrauds(fraudsList, 3);
        System.out.println("2. Top 3 Fraudes de Maior Valor:\n");
        topFrauds.forEach(System.out::println);

        var suspects = FraudAnalyzer.suspectsClientsNameList(items, 5);
        System.out.println("3. Clientes Suspeitos:\n");
        suspects.forEach(System.out::println);

        var totalFraudSum = FraudAnalyzer.totalFraudsAmount(items);
        System.out.println("4. Total de Fraudes de Maior Valor: " + totalFraudSum);

        Map<TransactionType, Long> transactionTypeLongMap = FraudAnalyzer.countFraudsByType(items);
        System.out.println("Fraudes por tipo:");
        transactionTypeLongMap.entrySet().forEach(System.out::println);

    } catch (Exception ex) {
        System.out.println("Something goes wrong!");
    }
}