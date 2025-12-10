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

    //busca por id
    @GetMapping(value = {"{cliente}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Cliente> get(@PathVariable("cliente") Integer id) {
        Cliente retorno = clienteService.busca(id);
        return ResponseEntity.status(HttpStatus.OK).body(retorno);
    }


    //edita um user recebendo id no localhost:8080/cliente/cpf
    @PutMapping(value = {"{cliente}"}, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> editar(@PathVariable("cliente") Integer id, @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.editar(id , cliente));
    }

    //remover cliente por id
    @DeleteMapping(value = {"{cliente}"})
    public ResponseEntity<Cliente> remover(@PathVariable("cliente") Integer id) {
        clienteService.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
