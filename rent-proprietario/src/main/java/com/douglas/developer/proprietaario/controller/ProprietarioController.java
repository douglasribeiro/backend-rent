package com.douglas.developer.proprietaario.controller;

import com.douglas.developer.core.controller.ControllerBasic;
import com.douglas.developer.core.entity.Imovel;
import com.douglas.developer.core.entity.Proprietario;
import com.douglas.developer.proprietaario.service.ProprietarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/proprietario")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ProprietarioController implements ControllerBasic<Proprietario> {

    private final ProprietarioService service;

    @Override
    public ResponseEntity<String> status() {
        log.info("Serviço de proprietario esta ok!");
        return new ResponseEntity<>("Serviço de proprietario esta ok!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Proprietario>> findAllClientAtivo(Boolean ativo, Jwt jwt) {
        return new ResponseEntity<>(service.findByAtivoAndCliente(ativo, jwt),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Proprietario> findbyId(Long id, Jwt jwt) {
        log.info("Proprietario código: '{}'", id);
        return new ResponseEntity<>(service.findById(id, jwt), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> insert(Proprietario proprietario, Jwt jwt) {
        log.info("Imovel '{}'", proprietario);
        Proprietario obj = service.save(proprietario, jwt);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<HttpStatus> update(Proprietario proprietario, Long id, Jwt jwt) {
        log.info("Proprietario atualizado '{}'", proprietario);
        service.update(id, proprietario, jwt);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id, Jwt jwt) {
        log.info("Proprietario excluido '{}'", id);
        service.delete(id, jwt);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
