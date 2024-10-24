package br.com.devsuzarte.desafioitaujunior.service;

import br.com.devsuzarte.desafioitaujunior.entity.StatisticsEntity;
import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import br.com.devsuzarte.desafioitaujunior.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class StatisticsService {

    private final TransactionRepository transactionRepository;

    public StatisticsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public StatisticsEntity getStatistics() {
        log.info("Starting searching....");
        List<TransactionEntity> transactions = transactionRepository.getTransactions();

        log.info("Catching dateTime");
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime past = OffsetDateTime.now().minusSeconds(60);

        log.info("Verifying list from the last 60 seconds");
        List<TransactionEntity> lastTransactions = transactions.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(past))
                .toList();

        log.info("Verifying if there are transactions within last 60 seconds");
        if(lastTransactions.isEmpty()) {
          return  new StatisticsEntity(0, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }

        log.info("Initializing variables");
        int count = lastTransactions.size();
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal min = BigDecimal.valueOf(Double.MIN_VALUE);
        BigDecimal max = BigDecimal.valueOf(Double.MAX_VALUE);

        log.info("Calculating statistics");
        for(TransactionEntity transaction : lastTransactions) {
            BigDecimal value = transaction.getValor();

            sum = sum.add(value); // Soma os todos os valores

            // Salva os menores valores encontrados
            if(value.compareTo(min) < 0) {
                min = value;
            }

            // Salva os maiores valores encontrados
            if(value.compareTo(max) > 0) {
                max = value;
            }

        }

        BigDecimal average = sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);

        return new StatisticsEntity(count, sum, average, min, max);
    }

}
