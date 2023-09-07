package com.douglas.developer.core.repository;

import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findBySigla(String uf);

}
