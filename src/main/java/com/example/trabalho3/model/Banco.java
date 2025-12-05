package com.example.trabalho3.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "banco")
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String codigo;

    @Column
    private String nome;

    //Notnull para não aceitar nulo e nullable para aceitar os valores do tamanho igual 14 caracteres
    @Column(nullable = false, unique = true, length = 14)
    @NotNull(message = "CNPJ não pode ser nulo ")

    private String cnpj;


    public Banco(){}


    public Banco(String codigo, String cnpj, String nome) {
        this.codigo = codigo;
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public @NotNull(message = "CNPJ não pode ser nulo ") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "CNPJ não pode ser nulo ") String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(codigo, banco.codigo) && Objects.equals(nome, banco.nome) && Objects.equals(cnpj, banco.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nome, cnpj);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
