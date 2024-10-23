package br.com.devsuzarte.desafioitaujunior.service;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransactionService {

    public void perform(TransactionEntity transaction) {
        ValidateTransaction(transaction);
    }

    private void ValidateTransaction(TransactionEntity transaction) {
        if(transaction.getValor().compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException(); //422: Unprocessable Entity
        if(transaction.getDataHora().isAfter(OffsetDateTime.now())) throw new IllegalArgumentException(); //422: Unprocessable Entity
    }

}
