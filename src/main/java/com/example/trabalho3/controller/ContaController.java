package com.example.trabalho3.controller;

import com.example.trabalho3.model.Conta;
import com.example.trabalho3.service.ContaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping (path = "conta")
public class ContaController {

    private ContaService contaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Conta>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.buscaTodos());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Conta> cadastrar(@RequestBody @Valid Conta conta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadatrar(conta));
    }

    @DeleteMapping(value = {"{conta}"})
    public ResponseEntity<Conta> remover(@PathVariable("conta") int numero) {
        contaService.remover(numero);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*@GetMapping(value = {"{conta}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Conta> get(@PathVariable("conta") int numero) {
        //Conta retorno = contaService.buscarNumero(numero);
        //return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }
    */

}