import br.com.zenon.fraud.TransactionIngestor;

void main() {
    try {
        TransactionIngestor ingestor = new TransactionIngestor();
        var itens = ingestor.Ingestor("zenon-fraud-detector/data/PS_20174392719_1491204439457_log.csv", 10);
        System.out.println("\n\n---------Relatorio--------------\n\n");
        itens.stream().limit(10).forEach(System.out::println);
    } catch (Exception ex) {
        System.out.println("Something goes wrong!");
    }
}