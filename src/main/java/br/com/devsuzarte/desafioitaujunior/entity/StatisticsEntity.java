package br.com.devsuzarte.desafioitaujunior.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsEntity {
    private int count;
    private BigDecimal sum;
    private BigDecimal average;
    private BigDecimal min;
    private BigDecimal max;
}
