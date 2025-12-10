package com.example.trabalho3.repository;

import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepository  extends JpaRepository<Conta, Integer> {
    List<Conta> findContaByNumeroContains(String numero);


}

