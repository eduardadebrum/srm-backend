package com.eduardadebrum.srmBackend.repository;

import com.eduardadebrum.srmBackend.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Eduarda de Brum Lucena
 */
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
