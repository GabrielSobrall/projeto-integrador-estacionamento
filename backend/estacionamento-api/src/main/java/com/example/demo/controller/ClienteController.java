package com.example.demo.controller;
//Imports
import com.example.demo.model.Cliente;
import com.example.demo.model.Veiculo;
import com.example.demo.service.ClienteService;
import com.example.demo.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private VeiculoService veiculoService;

    //Buscar perfil do cliente
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    //Atualizar perfil do cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,
                                                    @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = clienteService.atualizarCliente(id, clienteAtualizado);
        return ResponseEntity.ok(cliente);
    }

    //Consultar saldo
    @GetMapping("/{id}/saldo")
    public ResponseEntity<Double> getSaldo(@PathVariable Long id) {
        double saldo = clienteService.consultarSaldo(id);
        return ResponseEntity.ok(saldo);
    }

    //Adicionar saldo
    @PostMapping("/{id}/saldo/adicionar")
    public ResponseEntity<Double> adicionarSaldo(@PathVariable Long id,
                                                 @RequestParam double valor) {
        double novoSaldo = clienteService.adicionarSaldo(id, valor);
        return ResponseEntity.ok(novoSaldo);
    }

    //Listar veículos vinculados ao cliente
    @GetMapping("/{id}/veiculos")
    public ResponseEntity<List<Veiculo>> listarVeiculos(@PathVariable Long id) {
        List<Veiculo> veiculos = veiculoService.listarPorCliente(id);
        return ResponseEntity.ok(veiculos);
    }
}
