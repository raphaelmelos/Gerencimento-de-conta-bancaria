package com.example.trabalho3.repository;

import com.example.trabalho3.model.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    // busca uma agencia pelo numero
    Optional<Agencia> findByNumero(String numero);

    // verifica se ja existe uma agencia com esse numero
    boolean existsByNumero(String numero);

}
