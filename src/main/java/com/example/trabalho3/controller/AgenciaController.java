package com.example.trabalho3.controller;

import com.example.trabalho3.model.Agencia;
import com.example.trabalho3.service.AgenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // CONtrorler que respomdne JSON (API)
@RequestMapping(path = "agencias")  // prefixo da rota

public class AgenciaController {
    private final  AgenciaService service;

    public AgenciaController(AgenciaService service) {
        this.service = service;
    }

    @PostMapping
    public  Agencia cadastrar(@RequestBody Agencia agencia) {
        // Controller nao faz validação joga a responsa pro service
        return service.cadastrar(agencia);
    }

    @GetMapping
    public List<Agencia> listarAgencias() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public  Agencia buscarId(@PathVariable Long id) {
        return  service.buscarPorId(id);
    }

    @GetMapping("/numero/{numero}")
    public Agencia buscarNumero(@PathVariable String numero){
        return service.buscarPorNumero(numero);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }

    @PutMapping("/{id}")
    public Agencia editar(@PathVariable Long id, @RequestBody Agencia agencia){
        return service.editar(id, agencia);
    }

}
