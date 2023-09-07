package com.douglas.developer.core.service;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface ServiceBasic<T> {

    List<T> findAll();

    T findById(Long id, Jwt jwt);

    T save(T t, Jwt jwt);

    T update(Long id, T t, Jwt jwt);

    void delete(Long id, Jwt jwt);

    List<T> findByAtivoAndCliente(Boolean ativo, Jwt jwt);
}
