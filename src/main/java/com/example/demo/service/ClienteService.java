package com.example.demo.service;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll()
                .stream()
                .toList();
    }

    public Optional<Cliente> buscarById(Long id){
        return clienteRepository.findById(id);
    }

    public Cliente criarCliente(Cliente cliente){
        Cliente clienteNovo = clienteRepository.save(cliente);
        return clienteNovo;
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente atualizarCliente(Long id, Cliente updateCliente){
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(updateCliente.getNome());
                    cliente.setEmail(updateCliente.getEmail());
                    cliente.setSenha(updateCliente.getSenha());

                    Cliente clienteAtualizado = clienteRepository.save(cliente);
                    return clienteAtualizado;
                }).orElseThrow(() -> new RuntimeException("Cliente não existe!"));
    }

}