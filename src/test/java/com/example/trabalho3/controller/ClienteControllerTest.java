package com.example.trabalho3.controller;

import com.example.trabalho3.DemoApplication;
import com.example.trabalho3.model.Cliente;
import com.example.trabalho3.service.ClienteService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles( "test")
@AutoConfigureMockMvc
public class ClienteControllerTest {
    private static final ObjectMapper MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    private Cliente build(Integer id, String nome, String cpf){
        return new Cliente(id, nome, cpf);
    }



}
