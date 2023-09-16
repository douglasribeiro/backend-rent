package com.douglas.developer.imovel.controller;

import com.douglas.developer.core.controller.ControllerBasic;
import com.douglas.developer.core.dto.ImovelDto;
import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Imovel;
import com.douglas.developer.imovel.service.ImovelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/imovel")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
public class ImovelController implements ControllerBasic<Imovel> {

    private final ImovelService service;

    @GetMapping()
    public Map<String, Object> getPrincipalUser(@AuthenticationPrincipal Jwt jwt) {
        //var lista = Collections.singletonMap("principal", jwt);
        var email = jwt.getClaimAsString("email");
        String[] parts = email.split("[@._]");
        //log.info(parts[0]);
        log.info(parts[1]);
        //log.info(parts[2]);
        return Collections.singletonMap("principal", jwt);
    }

    @GetMapping(value = "/statusx" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> statusX() {
        log.info("Serviço de imóveis esta ok!");
        return new ResponseEntity<>("Serviço de imóveis esta ok!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> status() {
        log.info("Serviço de imóveis esta ok!");
        return new ResponseEntity<>("Serviço de imóveis esta ok!",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Imovel>> findAllClientAtivo(Boolean ativo,  @AuthenticationPrincipal Jwt jwt){
        //Cliente cliente = Cliente.builder().id(client).build();
        return new ResponseEntity<>(service.findByAtivoAndCliente(ativo, jwt),HttpStatus.OK);
        //retornarSucesso(headers, HttpStatus.OK, service.findByAtivoAndCliente(ativo, cliente));
    }

    @Override
    public ResponseEntity<Imovel> findbyId(Long id, @AuthenticationPrincipal Jwt jwt) {
        log.info("Imóvel código: '{}'", id);
        return new ResponseEntity<>(service.findById(id, jwt), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> insert(Imovel imovel, @AuthenticationPrincipal Jwt jwt) {
        log.info("Imovel '{}'", imovel);
        Imovel obj = service.save(imovel, jwt);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<HttpStatus> update(Long id, Imovel imovel , @AuthenticationPrincipal Jwt jwt) {
        log.info("Imovel atualizado '{}'", imovel);
        service.update(id, imovel, jwt);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id, @AuthenticationPrincipal Jwt jwt) {
        log.info("Imovel excluido '{}'", id);
        service.delete(id, jwt);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(value = "/prop/{id}" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Imovel>> getImoveisFromProprietario(@PathVariable(name = "id") Long id, @AuthenticationPrincipal Jwt jwt){
        log.info("Lista imovel por proprietario");
        var obj = service.listImoveisOfProprietario(jwt);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

}
