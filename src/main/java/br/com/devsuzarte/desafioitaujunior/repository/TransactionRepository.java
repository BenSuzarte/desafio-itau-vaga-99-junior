package br.com.devsuzarte.desafioitaujunior.repository;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TransactionRepository {

    private final List<TransactionEntity> transactions = new ArrayList<>();

    public void save(TransactionEntity transaction) {
        log.info("Saving transaction: {}", transaction);
        transactions.add(transaction);
    }

    public void clear() {
        log.info("Clearing transactions");
        transactions.clear();
    }

}
