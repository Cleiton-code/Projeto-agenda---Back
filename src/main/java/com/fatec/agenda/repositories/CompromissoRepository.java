package com.fatec.agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.agenda.entities.Compromisso;

public interface CompromissoRepository extends JpaRepository <Compromisso, Long> {
    
}
