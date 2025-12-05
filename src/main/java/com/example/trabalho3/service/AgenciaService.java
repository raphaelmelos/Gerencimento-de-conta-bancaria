package com.example.trabalho3.service;


import com.example.trabalho3.model.Agencia;
import com.example.trabalho3.repository.AgenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgenciaService {
    private final AgenciaRepository repository;

    public AgenciaService(AgenciaRepository repository) {
        this.repository = repository;
    }

    public Agencia cadastrar(Agencia agencia) {
        // validacoes obrigatorias
        if (agencia.getNumero() == null || agencia.getNumero().isBlank()) {
            throw new IllegalArgumentException("Número é obrigatório.");
        }

        if (agencia.getNome() == null || agencia.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }

        // garante numero unico
        if (repository.existsByNumero(agencia.getNumero())) {
            throw new IllegalArgumentException("Já existe uma agência com esse número.");
        }

        return repository.save(agencia);
    }

    public List<Agencia> listarTodas() {
        return repository.findAll();
    }
    public Agencia buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Agencia Nao Encopntrada."));
    }
    public Agencia buscarPorNumero(String numero) {
        return repository.findByNumero(numero)
                .orElseThrow(() -> new IllegalArgumentException("agencia nao encontradad com esse numero."));
    }

    public void remover(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("agencia nao encontrada para remocao");
        }
        repository.deleteById(id);
    }

    public Agencia editar(Long id, Agencia dados) {
        Agencia existente = buscarPorId(id);

        if (dados.getNome() != null && !dados.getNome().isBlank()) {
            existente.setNome(dados.getNome());
        }

        // numero não pode ser repetido
        if (dados.getNumero() != null && !dados.getNumero().isBlank()) {
            if (!dados.getNumero().equals(existente.getNumero()) &&
                    repository.existsByNumero(dados.getNumero())) {
                throw new IllegalArgumentException("ja existe outra agencia com esse numero.");
            }
            existente.setNumero(dados.getNumero());
        }

        return repository.save(existente);
    }
}

