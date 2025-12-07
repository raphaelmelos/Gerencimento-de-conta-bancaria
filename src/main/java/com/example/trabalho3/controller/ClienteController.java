package com.example.trabalho3.controller;

import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Cliente>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscaTodos());
    }

    //salvar cliente
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> adicionar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
    }

    //busca por cpf
    @GetMapping(value = {"{cliente}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> get(@PathVariable("cliente") String cpf) {
        Cliente retorno = clienteService.busca(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }


    //edita um user recebendo cpf no localhost:8080/cliente/cpf
    @PutMapping(value = {"{cliente}"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> editar(@PathVariable("cliente") String cpf, @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.editar(cpf, cliente));
    }

    //remover user
    @DeleteMapping(value = {"{cep}"})
    public ResponseEntity<Cliente> remover(@PathVariable("cliente") String cpf) {
        clienteService.remover(cpf);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
