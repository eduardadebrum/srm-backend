package com.eduardadebrum.srmBackend.controller;

import com.eduardadebrum.srmBackend.model.Cliente;
import com.eduardadebrum.srmBackend.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/** Classe controller contendo as requisições.
 *
 * @author Eduarda de Brum Lucena
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public Iterable<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/cliente")
    public Cliente findById() {
        return null;
    }

    @PostMapping("saveCliente")
    public Cliente save(@Valid @RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("updateCliente")
    public Cliente update(@Valid @RequestBody Cliente cliente) {
        return clienteService.update(cliente);
    }
}
