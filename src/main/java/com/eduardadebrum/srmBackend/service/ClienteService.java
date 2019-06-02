package com.eduardadebrum.srmBackend.service;

import com.eduardadebrum.srmBackend.model.Cliente;
import com.eduardadebrum.srmBackend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe responsavél pela camada de serviço.
 *
 * @author Eduarda de Brum Lucena
 */
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente) {
        Cliente clienteDb = clienteRepository.findById(cliente.getIdCliente()).get();
        clienteDb.setNome(cliente.getNome());
        clienteDb.setLimiteCredito(cliente.getLimiteCredito());
        clienteDb.setRisco(cliente.getRisco());
        return clienteRepository.save(clienteDb);
    }

    public Iterable<Cliente> findAll() {
        return clienteRepository.findAll();
    }
}
