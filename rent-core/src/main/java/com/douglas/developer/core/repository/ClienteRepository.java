package com.douglas.developer.core.repository;

import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByDominio(String dominio);
}
