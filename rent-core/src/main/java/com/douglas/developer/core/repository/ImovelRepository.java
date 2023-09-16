package com.douglas.developer.core.repository;

import com.douglas.developer.core.dto.ImovelDto;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {

    List<Imovel> findByAtivoAndCliente(Boolean ativo, Cliente cliente);

    Optional<Imovel> findByIdAndCliente(Long id, Cliente cliente);

    @Query(
            value = "select * " +
                    "from imovel_proprietario ip " +
                    "right join imovel i on i.id = ip.imovel_id " +
                    "where i.cliente_id = ?1"
            ,nativeQuery = true)
    List<Imovel> listImoveisOfProprietario(Long cliente);
}
