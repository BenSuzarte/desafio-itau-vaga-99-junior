package br.com.devsuzarte.desafioitaujunior.controller;

import br.com.devsuzarte.desafioitaujunior.entity.TransactionEntity;
import br.com.devsuzarte.desafioitaujunior.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        value = "/transacao", // Nome obrigatório do endpoint
        produces = MediaType.APPLICATION_JSON_VALUE, // Leitura apenas de JSONs
        consumes = MediaType.APPLICATION_JSON_VALUE // Respostas apenas com JSONs
)
public class TransactionController {

    private TransactionService transactionService;

    // Responsável pela realização transação
    public ResponseEntity<Void> transfer(@RequestBody TransactionEntity transaction) {
        return ResponseEntity.status(HttpStatus.CREATED).build(); // 201: CREATED
    }

}
