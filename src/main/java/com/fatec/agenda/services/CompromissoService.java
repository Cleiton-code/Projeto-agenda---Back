package com.fatec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.CompromissoRequest;
import com.fatec.agenda.dtos.CompromissoResponse;
import com.fatec.agenda.entities.Compromisso;
import com.fatec.agenda.mappers.CompromissoMapper;
import com.fatec.agenda.repositories.CompromissoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompromissoService {
    
    @Autowired
    private CompromissoRepository repository;

    public List<CompromissoResponse> getAllCompromisso() {
return repository.findAll().stream().map(p -> CompromissoMapper.toDTO(p)).collect(Collectors.toList());
    }

    public CompromissoResponse GetCompromissoById(long id){
        Compromisso compromisso = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Compromisso não cadastrado")
        );

        return CompromissoMapper.toDTO(compromisso);
    }

    public void delete(long id){
        if (repository.existsById(id)) {
            
        repository.deleteById(id);
    }else{
        throw new EntityNotFoundException("Compromisso não encontrado");
    }
    }

    public CompromissoResponse save(CompromissoRequest compromisso){
        Compromisso newCompromisso = repository.save(CompromissoMapper.toEntity(compromisso));
        return CompromissoMapper.toDTO(newCompromisso);
    }

    public void update(CompromissoRequest compromisso,long id){
        Compromisso aux = repository.getReferenceById(id);

        aux.setTitle(compromisso.title());
        aux.setDescricao(compromisso.descricao());
        aux.setDatacompromisso(compromisso.datacompromisso());
        aux.setInicio(compromisso.inicio());
        aux.setFim(compromisso.fim());
        aux.setLocal(compromisso.local());
        aux.setSituacao(compromisso.situacao());

        repository.save(aux);
    }
}
