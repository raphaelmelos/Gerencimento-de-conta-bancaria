package com.example.trabalho3.service;

import com.example.trabalho3.model.Banco;
import com.example.trabalho3.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BancoService {

    @Autowired
    private BancoRepository bancoRepository;

    //salvar cliente
    public Banco salvar(Banco banco){
        bancoRepository.save(banco);
        return banco;
    }

    //buscar todos os clientes

    //buscar por id

    //busca por nome

    //editar dados

}
