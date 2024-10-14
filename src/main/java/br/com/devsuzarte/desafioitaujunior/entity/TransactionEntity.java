package br.com.devsuzarte.desafioitaujunior.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    private BigDecimal valor;
    private OffsetDateTime dataHora;
}
