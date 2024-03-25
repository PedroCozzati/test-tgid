package com.example.tgid.controller;

import com.example.tgid.transacao.Transacao;
import com.example.tgid.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<Transacao>> getAllTransacoes() {
        List<Transacao> transacoes = transacaoService.getAllTransacoes();
        return new ResponseEntity<>(transacoes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Transacao> createTransacao(@RequestBody Transacao transacao,
            @RequestParam Long clienteId,
            @RequestParam Long empresaId) {
        Transacao novaTransacao = transacaoService.createTransacao(transacao, clienteId, empresaId);
        return new ResponseEntity<>(novaTransacao, HttpStatus.CREATED);
    }
}
