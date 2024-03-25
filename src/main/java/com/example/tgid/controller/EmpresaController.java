package com.example.tgid.controller;

import com.example.tgid.empresa.Empresa;
import com.example.tgid.services.EmpresaService;
import com.example.tgid.sistema.Sistema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllEmpresas() {
        List<Map<String, Object>> empresas = empresaService.getAllEmpresas();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empresa> createEmpresa(@RequestBody Empresa empresa) {
        if (Sistema.validarDocumento(empresa.getCnpj())){
        Empresa novaEmpresa = empresaService.createEmpresa(empresa);
        return new ResponseEntity<>(novaEmpresa, HttpStatus.CREATED);
        }
        return null;
    }

}
