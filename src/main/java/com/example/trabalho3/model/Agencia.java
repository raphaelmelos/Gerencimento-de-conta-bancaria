package com.example.trabalho3.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity                 // informa ao JPA que a classe vira uma tabela
@Table(name = "agencias")
public class Agencia {

    @Id                 // chave primária
    @GeneratedValue(strategy = GenerationType.SEQUENCE)  // auto-incremento
    private Long id;

    @Column(nullable = false, unique = true)   // obrigatório + não pode repetir
    private String numero;

    @Column(nullable = false)   // obrigatório
    private String nome;

    public Agencia(){}

    public Agencia(Long id, String numero, String nome) {
        this.id = id;
        this.numero = numero;
        this.nome = nome;
    }

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return Objects.equals(id, agencia.id) && Objects.equals(numero, agencia.numero) && Objects.equals(nome, agencia.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, nome);
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}