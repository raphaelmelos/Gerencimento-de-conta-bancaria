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
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    public void SetUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testaAdicao(){
        Cliente inserir = build(1,"Rphae", "siahha");

        doAnswer(invocation -> {
            return inserir;
        }).when(clienteRepository.save(inserir));

        Cliente retorno = clienteService.salvar(inserir);

        verify(clienteRepository, times(1)).save(eq(inserir));
        assertThat("Não retornou o clinete"), retorno.getNome(), equals(inserir.getNome()));
    }

}
