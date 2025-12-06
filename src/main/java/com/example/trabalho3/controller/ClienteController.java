package com.example.trabalho3.controller;

import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Cliente>> get(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscaTodos());
    }


}
