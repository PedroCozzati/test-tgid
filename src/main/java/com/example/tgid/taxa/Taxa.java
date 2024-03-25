package com.example.tgid.taxa;

public class Taxa {
    private String nome;
    private double valor;

    public Taxa(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }
}