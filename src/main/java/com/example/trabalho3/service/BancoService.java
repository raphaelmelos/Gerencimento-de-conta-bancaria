package com.example.trabalho3.service;

import com.example.trabalho3.controller.BancoController;
import com.example.trabalho3.exception.RegistroNaoEncontradoException;
import com.example.trabalho3.model.Banco;
import com.example.trabalho3.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Banco> buscaTodos(){ return bancoRepository.findAll(); }

    //buscar por id
    public Banco busca (Integer id) {
        Optional<Banco> busca = bancoRepository.findById(id);
        return busca.orElseThrow(() ->new RegistroNaoEncontradoException("Id" + id + " não encontrado"));

    }
    //busca por nome
    public List<Banco> buscaNome(String nome){return bancoRepository.findBancoByCodigoContains(nome);}

    //editar dados
    public Banco editar (Integer id, Banco banco ){
        Banco bancoBusca = this.busca(id);

        bancoBusca.setCodigo(banco.getCodigo());
        bancoBusca.setCnpj(banco.getCnpj());
        bancoBusca.setNome(banco.getNome());

        bancoRepository.save(bancoBusca);

        return bancoBusca;
    }
    public void remover(Integer id){
        Banco idBusca = this.busca(id);
        bancoRepository.delete(idBusca);
    }


}
