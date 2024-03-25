package com.example.tgid.services;

import com.example.tgid.transacao.Transacao;

import jakarta.persistence.EntityNotFoundException;

import com.example.tgid.cliente.Cliente;
import com.example.tgid.empresa.Empresa;
import com.example.tgid.repositories.ClienteRepo;
import com.example.tgid.repositories.EmpresaRepo;
import com.example.tgid.repositories.TransacaoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepo transacaoRepository;

    @Autowired
    private ClienteRepo clienteRepository;

    @Autowired
    private EmpresaRepo empresaRepository;

    public List<Transacao> getAllTransacoes() {
        return transacaoRepository.findAll();
    }
   
    public Transacao createTransacao(Transacao transacao, Long clienteId, Long empresaId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteId);
        Optional<Empresa> empresaOptional = empresaRepository.findById(empresaId);

        if (clienteOptional.isPresent() && empresaOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            Empresa empresa = empresaOptional.get();

            transacao.cliente=cliente;
            transacao.empresa=empresa;

            return transacaoRepository.save(transacao);
        } else {
            throw new EntityNotFoundException("Cliente ou empresa não encontrada");
        }
    }

}
