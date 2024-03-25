package com.example.tgid.empresa;
import com.example.tgid.sistema.Sistema;
import com.example.tgid.taxa.Taxa;
import com.example.tgid.transacao.Transacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String cnpj;
    private double taxa = 0.2;
    private double saldo;

    @OneToMany(mappedBy = "empresa")
    private List<Transacao> transacoes;

    public Empresa(String cnpj) {
        this.cnpj = cnpj;
        this.saldo = 0.0;
        this.taxa= 0.2;
    }

    public Empresa() {
        // Construtor padrão vazio
    }

    
    public void adicionarSaldo(double valor) {
        this.saldo += valor;
    }

    public void removerSaldo(double valor) {
        this.saldo -= valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public double getSaldo() {
        return saldo;
    }

 

    // Método para enviar callback
}
