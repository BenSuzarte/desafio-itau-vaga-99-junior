package br.com.devsuzarte.desafioitaujunior.repository;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    private final List<TransactionEntity> transactions = new ArrayList<>();

    public void save(TransactionEntity transaction) {
        transactions.add(transaction);
    }

    public void clear() {
        transactions.clear();
    }

}
