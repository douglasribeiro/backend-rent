package com.douglas.developer.core.repository;

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
            value = "select pi.*, i.* from proprietario_imovel pi, imovel i " +
                    " where pi.imovel_id = i.id and" +
                    " pi.proprietario_id=?1 and i.cliente_id = ?2"
            ,nativeQuery = true)
    List<Imovel> listImoveisOfProprietario(Long id, Long cliente);
}
