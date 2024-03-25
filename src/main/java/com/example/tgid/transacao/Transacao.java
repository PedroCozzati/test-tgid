package com.example.tgid.transacao;

import com.example.tgid.cliente.Cliente;
import com.example.tgid.empresa.Empresa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoTransacaoEnum tipo;
    private double valor;

    @ManyToOne
    public Empresa empresa;

    @ManyToOne
    public Cliente cliente;

    public Transacao(TipoTransacaoEnum tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }
}