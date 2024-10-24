package br.com.devsuzarte.desafioitaujunior.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatisticsEntity {
    private int count;
    private float sum;
    private float average;
    private float min;
    private float max;
}
