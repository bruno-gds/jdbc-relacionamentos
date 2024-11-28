package com.example.jdbc_tests.controller;

import com.example.jdbc_tests.controller.json.ClienteComPedidosJson;
import com.example.jdbc_tests.service.ObterClienteComPedidosService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    private final ObterClienteComPedidosService obterClienteComPedidosService;

    public ClienteController(ObterClienteComPedidosService obterClienteComPedidosService) {
        this.obterClienteComPedidosService = obterClienteComPedidosService;
    }

    @GetMapping("{clienteId}")
    public ClienteComPedidosJson obterClienteComPedidos(@PathVariable Long clienteId) {
        return obterClienteComPedidosService.get(clienteId);
    }
}
