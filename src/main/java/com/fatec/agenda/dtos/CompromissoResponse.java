package com.fatec.agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record CompromissoResponse(
    Long id,
    String title,
    String descricao,
    LocalDate datacompromisso,
    LocalTime inicio,
    LocalTime fim,
    String local,
    String situacao
) {
    
}
