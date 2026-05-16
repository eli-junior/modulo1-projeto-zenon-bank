import br.com.zenon.fraud.TransactionIngestor;

void main() {
    try {
        TransactionIngestor ingestor = new TransactionIngestor();
        var itens = ingestor.Ingestor("zenon-fraud-detector/data/PS_20174392719_1491204439457_log.csv", 10);
        System.out.println("\n\n---------Relatorio--------------\n\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(itens.get(i));
        }
    } catch (Exception ex) {
        System.out.println("Something goes wrong!");
    }
}