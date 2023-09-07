package com.douglas.developer.generic.controller;

import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Estado;
import com.douglas.developer.core.repository.CidadeRepository;
import com.douglas.developer.core.repository.EstadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/generic/cidade")
@RequiredArgsConstructor
@Slf4j
public class CidadeController {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cidade>> getCidades(){
        return new ResponseEntity<>(cidadeRepository.findAll(),HttpStatus.OK);
    }

    @GetMapping(value = "/{uf}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Cidade>> getCidadesForUf(@PathVariable("uf") Long uf){
        Estado estado = estadoRepository.findById(uf).get();
        return new ResponseEntity<>(cidadeRepository.findByEstado(estado),HttpStatus.OK);
    }
}
