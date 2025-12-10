package com.example.trabalho3.repository;

import com.example.trabalho3.model.Banco;
import com.example.trabalho3.model.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BancoRepository extends JpaRepository<Banco, Integer> {
    List<Banco> findBancoByCodigoContains(String codigo);

}
