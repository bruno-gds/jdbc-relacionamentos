package com.example.jdbc_tests.controller;

import com.example.jdbc_tests.controller.json.ClienteComPedidosJson;
import com.example.jdbc_tests.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteComPedidosJson> listarTodosClientesComPedidos() {
        return clienteService.listarTodosClientesComPedidos();
    }

    @GetMapping("{clienteId}")
    public ClienteComPedidosJson obterClienteComPedidos(@PathVariable Long clienteId) {
        return clienteService.obterClienteComPedidos(clienteId);
    }

    @PostMapping
    public Long salvarClienteComPedidos(@RequestBody ClienteComPedidosJson clienteComPedidosJson) {
        return clienteService.salvarClienteComPedidos(clienteComPedidosJson);
    }

    @DeleteMapping("{clienteId}")
    public void deletarClienteComPedidos(@PathVariable Long clienteId) {
        clienteService.deletarClienteComPedidos(clienteId);
    }
}
