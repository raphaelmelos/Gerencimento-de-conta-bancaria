package com.example.trabalho3.repository;

import com.example.trabalho3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

        List<Cliente> findClienteByNomeContains(String nome);



}
