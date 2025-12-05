package com.example.trabalho3.service;

import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
