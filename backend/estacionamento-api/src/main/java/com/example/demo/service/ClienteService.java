package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente cliente = buscarPorId(id);
        cliente.setNome(clienteAtualizado.getNome());
        cliente.setEmail(clienteAtualizado.getEmail());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        return clienteRepository.save(cliente);
    }

    public double consultarSaldo(Long id) {
        Cliente cliente = buscarPorId(id);
        return cliente.getSaldo();
    }

    public double adicionarSaldo(Long id, double valor) {
        Cliente cliente = buscarPorId(id);
        cliente.setSaldo(cliente.getSaldo() + valor);
        clienteRepository.save(cliente);
        return cliente.getSaldo();
    }
}
