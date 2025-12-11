package com.example.trabalho3.service;

import com.example.trabalho3.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ContaServiceTest {

    @Mock
    private ContaRepository contaRepository;

    @InjectMocks
    private ContaService contaService;

    @BeforeEach
    public void setUp(){ MockitoAnnotations.initMocks(this); }


    @Test
    void testaAdicao(){
    }
}
