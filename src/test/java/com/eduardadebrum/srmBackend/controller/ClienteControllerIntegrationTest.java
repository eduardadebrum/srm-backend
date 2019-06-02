package com.eduardadebrum.srmBackend.controller;

import com.eduardadebrum.srmBackend.model.Cliente;
import com.eduardadebrum.srmBackend.model.RiscoEnum;
import com.eduardadebrum.srmBackend.repository.ClienteRepository;
import com.eduardadebrum.srmBackend.service.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Classe contendo os testes de integração.
 *
 * @author Eduarda de Brum Lucena
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class ClienteControllerIntegrationTest {

    private static final String SAVE = "/saveCliente";
    private static final String UPDATE = "/updateCliente";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void saveShouldSuccessStatusOk() throws Exception {
        //Mock
        Cliente cliente = new Cliente();
        cliente.setRisco(RiscoEnum.A);
        cliente.setLimiteCredito(new BigDecimal(12));
        cliente.setNome("Eduarda de Brum");

        ResultActions result = mockMvc.perform(post(SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(cliente)));

        result.andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void saveShouldFailWhenNameIsEmpty() throws Exception {
        //Mock
        Cliente cliente = new Cliente();
        cliente.setRisco(RiscoEnum.A);
        cliente.setLimiteCredito(new BigDecimal(12));
        cliente.setNome("");

        ResultActions result = mockMvc.perform(post(SAVE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(cliente)));

        result.andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].field").value("nome"))
                .andExpect(jsonPath("$[0].messageField").value("Nome do Cliente é Obrigatório"));
    }


    @Test
    public void updateShouldSuccessStatusOk() throws Exception {
        //Mock
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setRisco(RiscoEnum.A);
        cliente.setLimiteCredito(new BigDecimal(2990));
        cliente.setNome("Eduarda de Brum");

        ResultActions result = mockMvc.perform(put(UPDATE)
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(asJsonString(cliente)));

        result.andExpect(status().isOk())
                .andDo(print());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}