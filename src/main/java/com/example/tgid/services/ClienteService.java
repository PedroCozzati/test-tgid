package com.example.tgid.services;

import com.example.tgid.cliente.Cliente;
import com.example.tgid.empresa.Empresa;
import com.example.tgid.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo clienteRepository;


    public List<Map<String, Object>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                      .map(this::convertToMap)
                      .collect(Collectors.toList());
    }

    private Map<String, Object> convertToMap(Cliente cliente) {
        Map<String, Object> empresaMap = new HashMap<>();
        empresaMap.put("id", cliente.getId());
        empresaMap.put("cnpj", cliente.getCpf());
        return empresaMap;
    }

    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }


}
