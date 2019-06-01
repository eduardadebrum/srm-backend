package com.eduardadebrum.srmBackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Eduarda de Brum Lucena
 */
@RestController
public class ClienteController {

    @GetMapping("/associados")
    public String findAllEleitor() {
        return "Hello";
    }
}
