package br.com.devsuzarte.desafioitaujunior.service;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import br.com.devsuzarte.desafioitaujunior.exception.TransactionException.InvalidTransactionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Slf4j
@Service
public class TransactionService {

    public void perform(TransactionEntity transaction) {
        log.info("Validating transaction");
        ValidateTransaction(transaction);

        log.info("Finished validating transaction");
        return;
    }

    private void ValidateTransaction(TransactionEntity transaction) {
        log.info("Verifying value");
        if(transaction.getValor().compareTo(BigDecimal.ZERO) < 0) throw new InvalidTransactionException("Invalid value");

        log.info("Verifying dateTime");
        if(transaction.getDataHora().isAfter(OffsetDateTime.now())) throw new InvalidTransactionException("Invalid dateTime");
    }

}
