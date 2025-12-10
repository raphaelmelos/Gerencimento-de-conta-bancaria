package com.example.trabalho3.controller;

import com.example.trabalho3.model.Banco;
import com.example.trabalho3.service.BancoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "banco")
public class BancoController {

    @Autowired
    private BancoService bancoService;

    //buscar todoso
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Banco>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(bancoService.buscaTodos());
    }

    //salvar cliente
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Banco> adicionar(@RequestBody @Valid Banco banco) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bancoService.salvar(banco));
    }

    //buscar por id
    //editar

    @PutMapping(value = {"{banco}"}, produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Banco> editar (@PathVariable ("banco") Integer id,@RequestBody Banco banco) {
        return ResponseEntity.status(HttpStatus.OK).body(bancoService.editar(id, banco));
    }

    //remover
    @DeleteMapping(value = {"{banco}"})
    public ResponseEntity<Banco> remover(@PathVariable("banco")Integer id){
        bancoService.remover(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
