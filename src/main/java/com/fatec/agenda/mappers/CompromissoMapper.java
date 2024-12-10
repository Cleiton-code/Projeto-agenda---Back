package com.fatec.agenda.mappers;

import com.fatec.agenda.dtos.CompromissoRequest;
import com.fatec.agenda.dtos.CompromissoResponse;
import com.fatec.agenda.entities.Compromisso;

public class CompromissoMapper {
    
    public static CompromissoResponse toDTO(Compromisso compromisso){
        return new CompromissoResponse(compromisso.getId(),
        compromisso.getTitle(),
        compromisso.getDescricao(),
        compromisso.getDatacompromisso(),
        compromisso.getInicio(),
        compromisso.getFim(),
        compromisso.getLocal(),
        compromisso.getSituacao());
    }

    public static Compromisso toEntity(CompromissoRequest compromissoRequest){
        Compromisso compromisso = new Compromisso();
        compromisso.setTitle(compromissoRequest.title());
        compromisso.setDescricao(compromissoRequest.descricao());
        compromisso.setDatacompromisso(compromissoRequest.datacompromisso());
        compromisso.setInicio(compromissoRequest.inicio());
        compromisso.setFim(compromissoRequest.fim());
        compromisso.setLocal(compromissoRequest.local());
        compromisso.setSituacao(compromissoRequest.situacao());

        return compromisso;
    }
}
