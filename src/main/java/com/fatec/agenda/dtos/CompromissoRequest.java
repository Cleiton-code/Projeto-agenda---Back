package com.fatec.agenda.dtos;

import java.time.LocalDate;
import java.time.LocalTime;


import jakarta.validation.constraints.NotBlank;

public record CompromissoRequest(

@NotBlank(message="Coloque o titúlo")
    String title,

    String descricao,
    LocalDate datacompromisso,
    LocalTime inicio,
    LocalTime fim,
    String situacao,

    @NotBlank
    String local

    
) {

}
