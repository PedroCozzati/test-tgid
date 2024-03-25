package com.example.tgid.services;

import com.example.tgid.empresa.Empresa;
import com.example.tgid.repositories.EmpresaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepo empresaRepository;

    public List<Map<String, Object>> getAllEmpresas() {
        List<Empresa> empresas = empresaRepository.findAll();
        return empresas.stream()
                      .map(this::convertToMap)
                      .collect(Collectors.toList());
    }

    private Map<String, Object> convertToMap(Empresa empresa) {
        Map<String, Object> empresaMap = new HashMap<>();
        empresaMap.put("id", empresa.getId());
        empresaMap.put("cnpj", empresa.getCnpj());
        empresaMap.put("saldo", empresa.getSaldo());
        return empresaMap;
    }

    public Empresa createEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Optional<Empresa> getEmpresaById(Long id) {
        return empresaRepository.findById(id);
    }

}
