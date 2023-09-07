package com.douglas.developer.imovel.service;

import com.douglas.developer.core.entity.Cidade;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Imovel;
import com.douglas.developer.core.exceptoin.ObjectNotFoundException;
import com.douglas.developer.core.repository.ClienteRepository;
import com.douglas.developer.core.repository.ImovelRepository;
import com.douglas.developer.core.service.ServiceBasic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImovelService implements ServiceBasic<Imovel> {

    private final ImovelRepository repository;
    private final ClienteRepository clienteRepository;

    @Override
    public List<Imovel> findAll() {
        Cliente cliente = Cliente.builder().id(1L).build();
        return null; //repository.findByAtivoAndCliente(true);
    }

    @Override
    public Imovel findById(Long id, Jwt jwt) {
        return repository.findByIdAndCliente(id, getIdClient(jwt)).
                orElseThrow(() -> new ObjectNotFoundException("Codigo não encontrado."));
    }

    @Override
    public Imovel save(Imovel imovel, Jwt jwt) {
        imovel.setId(null);
        imovel.setCliente(Cliente.builder().id(getIdClient(jwt).getId()).build());
        imovel.setAtivo(true);
        return repository.save(imovel);
    }

    @Override
    public Imovel update(Long id, Imovel imovel, Jwt jwt) {
        Imovel obj = findById(id, jwt);
        if(imovel != obj) {
            obj.setBairro(imovel.getBairro());
            obj.setCidade(imovel.getCidade());
            obj.setNumero(imovel.getNumero());
            obj.setLogradouro(imovel.getLogradouro());
            obj.setReferencia(imovel.getReferencia());
            obj.setSituacao(imovel.getSituacao());
            obj.setQuartos(imovel.getQuartos());
            obj.setSuites(imovel.getSuites());
            obj.setBanheiros(imovel.getBanheiros());
            obj.setAreaTotal(imovel.getAreaTotal());
            obj.setAreaContruida(imovel.getAreaContruida());
            obj.setVagas(imovel.getVagas());
            obj.setContato(imovel.getContato());
            obj.setRegistro(imovel.getRegistro());
            obj.setIptu(imovel.getIptu());
            return repository.save(obj);
        }
        return null;
    }

    @Override
    public void delete(Long id, Jwt jwt) {
        Imovel obj = findById(id, jwt);
        repository.delete(obj);
    }

    @Override
    public List<Imovel> findByAtivoAndCliente(Boolean ativo, Jwt jwt) {
        return repository.findByAtivoAndCliente(ativo, getIdClient(jwt));
    }

    private Cliente getIdClient(Jwt jwt) {
        var email = jwt.getClaimAsString("email");
        String[] parts = email.split("[@._]");
        return clienteRepository.findByDominio(parts[1]).
                orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado."));
    }
}
