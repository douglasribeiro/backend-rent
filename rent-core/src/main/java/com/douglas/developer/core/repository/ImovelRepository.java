package com.douglas.developer.core.repository;

import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByAtivoAndCliente(Boolean ativo, Cliente cliente);

    Optional<Imovel> findByIdAndCliente(Long id, Cliente cliente);
}
