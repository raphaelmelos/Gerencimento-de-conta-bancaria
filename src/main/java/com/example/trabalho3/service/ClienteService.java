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
    public Cliente busca(String cpf){
        Optional<Cliente> busca = clienteRepository.findById(cpf);
        return busca.orElseThrow(() ->new RegistroNaoEncontradoException("nao encontrado"));
    }
    //busca por nome
    public List<Cliente> buscaNome(String nome){
        return clienteRepository.findClienteByNomeContains(nome);
    }
    //editar dados
    public Cliente editar(String cpf, Cliente cliente){
        Cliente clienteBusca = this.busca(cpf);

        clienteBusca.setCpf(cliente.getCpf());
        clienteBusca.setNome(cliente.getNome());

        clienteRepository.save(clienteBusca);

        return clienteBusca;
    }
    public void remover(String cpf){
        Cliente cpfBusca = this.busca(cpf);
        clienteRepository.delete(cpfBusca);
    }



}
