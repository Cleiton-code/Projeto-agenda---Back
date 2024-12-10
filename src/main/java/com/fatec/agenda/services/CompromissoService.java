package com.fatec.agenda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.agenda.dtos.CompromissoResponse;
import com.fatec.agenda.mappers.CompromissoMapper;
import com.fatec.agenda.repositories.CompromissoRepository;

@Service
public class CompromissoService {
    
    @Autowired
    private CompromissoRepository repository;

    public List<CompromissoResponse> getAllCompromisso() {
return repository.findAll().stream().map(p -> CompromissoMapper.toDTO(p)).collect(Collectors.toList());
    }
}
