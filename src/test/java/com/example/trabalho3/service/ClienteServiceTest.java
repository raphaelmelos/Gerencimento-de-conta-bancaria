package com.example.trabalho3.service;

import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.repository.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService service;

    @BeforeEach
    public void SetUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testaAdicao(){
        Cliente inserir = build(1,"Raphael", "84703385015");

        doAnswer(invocation -> {
            return inserir;
        }).when(clienteRepository).save(eq(inserir));

        Cliente retorno = service.salvar(inserir);

        verify(clienteRepository, times(1)).save(eq(inserir));
        assertThat("sasbasas", retorno.getCpf(), equalTo(inserir.getCpf()));
    }

    private Cliente build(Integer id, String nome, String cpf){
        return new Cliente(id,nome,cpf);
    }



}
