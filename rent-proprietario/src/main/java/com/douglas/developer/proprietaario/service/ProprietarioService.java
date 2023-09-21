package com.douglas.developer.proprietaario.service;

import com.douglas.developer.core.dto.ProprietarioDto;
import com.douglas.developer.core.entity.Cliente;
import com.douglas.developer.core.entity.Proprietario;
import com.douglas.developer.core.exceptoin.ObjectNotFoundException;
import com.douglas.developer.core.repository.ClienteRepository;
import com.douglas.developer.core.repository.ProprietarioRepository;
import com.douglas.developer.core.service.ServiceBasic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProprietarioService implements ServiceBasic<Proprietario> {

    private final ProprietarioRepository repository;
    private final ClienteRepository clienteRepository;

    @Override
    public List<Proprietario> findAll() {
        return null;
    }

    @Override
    public Proprietario findById(Long id, Jwt jwt) {
        return repository.findByIdAndCliente(id, getIdClient(jwt)).
                orElseThrow(() -> new ObjectNotFoundException("Codigo não encontrado."));
    }

    @Override
    public Proprietario save(Proprietario proprietario, Jwt jwt) {
        proprietario.setId(null);
        proprietario.setCliente(Cliente.builder().id(getIdClient(jwt).getId()).build());
        proprietario.setAtivo(true);
        return repository.save(proprietario);
    }

    @Override
    public Proprietario update(Long id, Proprietario proprietario, Jwt jwt) {
        Proprietario obj = findById(id, jwt);
        if(proprietario != obj){
            obj.setCpf(proprietario.getCpf());
            obj.setEmail(proprietario.getEmail());
            obj.setDtNasc(proprietario.getDtNasc());
            obj.setEstCivil(proprietario.getEstCivil());
            obj.setIdent(proprietario.getIdent());
            obj.setNacionalidade(proprietario.getNacionalidade());
            obj.setNaturalidade(proprietario.getNaturalidade());
            obj.setNome(proprietario.getNome());
            obj.setConjuge(proprietario.getConjuge());
            obj.setCpfConjuge(proprietario.getCpfConjuge());
            obj.setDtnConjuge(proprietario.getDtnConjuge());
            obj.setEnderecos(proprietario.getEnderecos());
            repository.save(obj);
        }
        return null;
    }

    @Override
    public void delete(Long id, Jwt jwt) {
        Proprietario obj = findById(id, jwt);
        repository.delete(obj);
    }

    @Override
    public List<Proprietario> findByAtivoAndCliente(Boolean ativo, Jwt jwt) {
        return repository.findByAtivoAndCliente(ativo, getIdClient(jwt));
    }

    private Cliente getIdClient(Jwt jwt) {
        var email = jwt.getClaimAsString("email");
        String[] parts = email.split("[@._]");
        return clienteRepository.findByDominio(parts[1]).
                orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado."));
    }

}
