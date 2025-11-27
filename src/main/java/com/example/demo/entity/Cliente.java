package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String nome;
    private String email;
    private String senha;


    public Cliente() {
    }

    public Cliente(Long cliente_id, String nome, String email, String senha) {
        this.cliente_id = cliente_id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long id) {
        this.cliente_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}