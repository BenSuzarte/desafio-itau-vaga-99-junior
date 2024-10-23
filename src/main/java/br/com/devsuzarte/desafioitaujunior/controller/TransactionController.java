package br.com.devsuzarte.desafioitaujunior.controller;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import br.com.devsuzarte.desafioitaujunior.exception.TransactionException.InvalidTransactionException;
import br.com.devsuzarte.desafioitaujunior.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(
        value = "/transacao", // Nome obrigatório do endpoint
        produces = MediaType.APPLICATION_JSON_VALUE, // Leitura apenas de JSONs
        consumes = MediaType.APPLICATION_JSON_VALUE // Respostas apenas com JSONs
)
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Responsável pela realização transação
    @PostMapping()
    public ResponseEntity<Void> transfer(@RequestBody TransactionEntity transaction) {
        try {
            log.info("Starting transfer...");
            transactionService.perform(transaction);

            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201: CREATED

        } catch (InvalidTransactionException err) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
