package com.douglas.developer.core.repository;

import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    List<Cidade> findByEstado(Estado uf);

    Cidade findByNomeAndEstado(String cidade, Estado estado);
}
