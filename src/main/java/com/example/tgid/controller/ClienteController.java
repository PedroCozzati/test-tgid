package com.example.tgid.controller;

import com.example.tgid.cliente.Cliente;
import com.example.tgid.services.ClienteService;
import com.example.tgid.sistema.Sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllClientes() {
        List<Map<String, Object>> clientes = clienteService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        if (Sistema.validarDocumento(cliente.getCpf())){
            Cliente novoCliente = clienteService.createCliente(cliente);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        }
        return null;
        
    }
}
