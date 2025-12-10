package com.example.trabalho3.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table (name = "conta")
public class Conta {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column
    private String numero;

    @Column
    private double saldo;

    @ManyToOne
    @JoinColumn (name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn (name = "agencia_id", nullable = false)
    private Agencia agencia;

    public Conta () {

    }

    public Conta(int id,String numero, double saldo, Cliente cliente, Agencia agencia) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.agencia = agencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conta conta)) return false;
        return id == conta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
