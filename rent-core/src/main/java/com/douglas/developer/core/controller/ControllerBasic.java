package com.douglas.developer.core.controller;

import com.douglas.developer.core.entity.Imovel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ControllerBasic<T> {

    @GetMapping(value = "/status" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> status();

    @GetMapping(value = "/client-ativo")
    public ResponseEntity<List<Imovel>> findAllClientAtivo(@RequestHeader(value = "ativo", defaultValue = "true") Boolean ativo,
                                                           @AuthenticationPrincipal Jwt jwt);

    @GetMapping(value = "/{id}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<T> findbyId(@PathVariable("id") Long id,
                                      @AuthenticationPrincipal Jwt jwt);

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody T t,
                                       @AuthenticationPrincipal Jwt jwt);

    @PutMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody T t, @PathVariable Long id,
                                             @AuthenticationPrincipal Jwt jwt);

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id,
                                             @AuthenticationPrincipal Jwt jwt);

}

