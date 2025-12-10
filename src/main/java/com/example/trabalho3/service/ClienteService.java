package com.example.trabalho3.service;

import com.example.trabalho3.exception.RegistroNaoEncontradoException;
import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    //salvar cliente
    public Cliente salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return cliente;
    }

    //buscar todos os clientes
    public List<Cliente> buscaTodos(){return clienteRepository.findAll();}

    //buscar por id
    public Cliente busca(Integer id){
        Optional<Cliente> busca = clienteRepository.findById(id);
        return busca.orElseThrow(() ->new RegistroNaoEncontradoException("Id" + id + " nao encontrado"));
    }
    //busca por nome
    public List<Cliente> buscaNome(String nome){
        return clienteRepository.findClienteByNomeContains(nome);
    }
    //editar dados
    public Cliente editar(Integer id, Cliente cliente){
        Cliente clienteBusca = this.busca(id);

        clienteBusca.setCpf(cliente.getCpf());
        clienteBusca.setNome(cliente.getNome());

        clienteRepository.save(clienteBusca);

        return clienteBusca;
    }
    public void remover(Integer id){
        Cliente idBusca = this.busca(id);
        clienteRepository.delete(idBusca);
    }



}
