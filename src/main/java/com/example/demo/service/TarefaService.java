package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.entity.Tarefa;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Tarefa criarTarefa(Tarefa tarefa) {
        Cliente cliente = clienteRepository.findById(tarefa.getCliente().getCliente_id())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        tarefa = tarefaRepository.save(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTarefas() {
        return tarefaRepository.findAll().stream()
                .toList();
    }

    public Tarefa buscarById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa atualizarTarefa(Long id, Tarefa newTarefa) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefa.setDescricao(newTarefa.getDescricao());
        tarefa.setConcluida(newTarefa.isConcluida());
        tarefa = tarefaRepository.save(tarefa);
        return tarefa;
    }

    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
