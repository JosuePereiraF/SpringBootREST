package com.example.demo.service;

import com.example.demo.dto.ClienteDTO;
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

    public List<ClienteDTO> listarClientes(){
        return clienteRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public Optional<ClienteDTO> buscarById(Long id){
        return clienteRepository.findById(id)
                .map(this::toDTO);
    }

    public ClienteDTO criarCliente(Cliente cliente){
        Cliente clienteNovo = clienteRepository.save(cliente);
        return toDTO(clienteNovo);
    }

    public void excluirCliente(Long id){
        clienteRepository.deleteById(id);
    }

    public ClienteDTO atualizarCliente(Long id, Cliente updateCliente){
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(updateCliente.getNome());
                    cliente.setEmail(updateCliente.getEmail());
                    cliente.setDataNasc(updateCliente.getDataNasc());
                    cliente.setSenha(updateCliente.getSenha());
                    cliente.setCpf(updateCliente.getCpf());
                    cliente.setEndereco(updateCliente.getEndereco());
                    cliente.setTelefone(updateCliente.getTelefone());

                    Cliente clienteAtualizado = clienteRepository.save(cliente);
                    return toDTO(clienteAtualizado);
                }).orElseThrow(() -> new RuntimeException("Cliente não existe!"));
    }

    private ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

}