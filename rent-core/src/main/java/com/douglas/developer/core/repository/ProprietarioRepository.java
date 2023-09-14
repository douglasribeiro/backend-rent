package com.douglas.developer.core.repository;

import com.douglas.developer.core.dto.ProprietarioDto;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Imovel;
import com.douglas.developer.core.entity.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProprietarioRepository extends JpaRepository<Proprietario, Long> {

    List<Proprietario> findByAtivoAndCliente(Boolean ativo, Cliente cliente);

    Optional<Proprietario> findByIdAndCliente(Long id, Cliente cliente);

}
