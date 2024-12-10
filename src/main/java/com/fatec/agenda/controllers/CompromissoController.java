package com.fatec.agenda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.agenda.dtos.CompromissoRequest;
import com.fatec.agenda.dtos.CompromissoResponse;
import com.fatec.agenda.services.CompromissoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin
@RestController
@RequestMapping("compromisso")
public class CompromissoController {
    
    @Autowired
    private CompromissoService service;

    @GetMapping
    public ResponseEntity<List<CompromissoResponse>> GetCompromisso() {
    		return ResponseEntity.ok(service.getAllCompromisso());
}

    @GetMapping("{id}")
    public ResponseEntity<CompromissoResponse> GetCompromisso(@PathVariable long id){
        return ResponseEntity.ok(service.GetCompromissoById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> DeleteCompromisso(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> UpdateCompromisso(@PathVariable long id, @Validated @RequestBody CompromissoRequest compromisso){
        service.update(compromisso, id);
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<CompromissoResponse> SaveCompromisso(@Validated @RequestBody CompromissoRequest compromisso){
        System.out.println("Payload Recebido: " + compromisso);
        CompromissoResponse newCompromisso = service.save(compromisso);
        return ResponseEntity.created(null).body(newCompromisso);
    }



    
}
