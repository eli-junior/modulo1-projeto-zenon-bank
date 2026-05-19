package br.com.zenon.fraud;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FraudAnalyzer {
    public static List<Transaction> fraudCounter(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(Transaction::isFraud)
                .toList();
    }

    public static List<String> topFrauds(List<Transaction> transactions, int limit) {
        var t = transactions
                .stream()
                .filter(Transaction::isFraud)
                .sorted(Comparator
                        .comparing(Transaction::amount)
                .reversed())
                .limit(limit);
        var result = new ArrayList<String>();
        t.forEach(x -> result.add(x.amount().toString()));
        return result;

    }
    public static List<String> suspectsClientsNameList(List<Transaction> transactions, int limit) {
        return transactions
                .stream()
                .filter(Transaction::isFraud)
                .sorted(Comparator
                        .comparing(Transaction::amount)
                        .reversed())
                .map(t -> t.origin().name())
                .distinct()
                .limit(limit)
                .toList();
    }
    public static BigDecimal totalFraudsAmount(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(Transaction::isFraud)
                .map(Transaction::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Map<TransactionType, Long> countFraudsByType(List<Transaction> transactions) {
        return transactions
                .stream()
                .filter(Transaction::isFraud)
                .collect(Collectors.groupingBy(Transaction::type, Collectors.counting()));
    }
}


