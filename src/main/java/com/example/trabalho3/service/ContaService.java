package com.example.trabalho3.service;

import com.example.trabalho3.exception.RegistroNaoEncontradoException;
import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.model.Conta;
import com.example.trabalho3.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta cadatrar (Conta novaConta) {
        return contaRepository.save(novaConta);
    }

    public void remover (Integer id) {
        Conta idbusca = this.busca(id);
        contaRepository.delete(idbusca);
    }
    public List<Conta> buscaTodos(){
        return contaRepository.findAll();
    }
    public Conta busca(Integer id){
        Optional<Conta> busca = contaRepository.findById(id);
        return busca.orElseThrow(() ->new RegistroNaoEncontradoException("Id" + id + " nao encontrado"));
    }

    public List<Conta> buscarNumero (String numero) {
        return contaRepository.findContaByNumeroContains(numero);
    }

    /*
    public Conta sacar (int numero, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do saque deve ser positivo.");
        }
        List<Conta> conta = contaRepository.findContaByNumeroContains(numero);
        if (this.saldo < valor) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
    }
*/
}
