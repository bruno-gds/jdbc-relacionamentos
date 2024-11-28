package com.example.jdbc_tests.service;

import com.example.jdbc_tests.controller.json.ClienteComPedidosJson;
import com.example.jdbc_tests.entity.ClienteEntity;
import com.example.jdbc_tests.entity.PedidoEntity;
import com.example.jdbc_tests.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ObterClienteComPedidosService {

    private final ClienteRepository clienteRepository;

    public ObterClienteComPedidosService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteComPedidosJson get(Long clienteId) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).get();

        return new ClienteComPedidosJson(clienteEntity.getNome(), clienteEntity.getPedidos().stream().map(PedidoEntity::getDescricao).toList());
    }
}
