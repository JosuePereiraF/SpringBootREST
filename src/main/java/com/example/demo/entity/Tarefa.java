package com.example.demo.entity;

import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.ClienteService;
import jakarta.persistence.*;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private boolean concluida;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Tarefa() {
    }

    public Tarefa(Long id, String descricao, boolean concluida, long idCliente) {
        ClienteService clienteService = new ClienteService();
        this.id = id;
        this.descricao = descricao;
        this.concluida = concluida;
        this.cliente = clienteService.buscarById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
