package com.example.jdbc_tests.service;

import com.example.jdbc_tests.controller.json.ClienteComPedidosJson;
import com.example.jdbc_tests.entity.ClienteEntity;
import com.example.jdbc_tests.entity.PedidoEntity;
import com.example.jdbc_tests.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteComPedidosJson> listarTodosClientesComPedidos() {
        var clientesEntity = clienteRepository.findAll();

        return clientesEntity.stream().map(
                cliente -> new ClienteComPedidosJson(
                        cliente.getNome(),
                        cliente.getPedidos().stream().map(PedidoEntity::getDescricao).toList())
        ).toList();
    }

    public ClienteComPedidosJson obterClienteComPedidos(Long clienteId) {
        Optional<ClienteEntity> clienteEntity = clienteRepository.findById(clienteId);

        if (clienteEntity.isEmpty()) {
            throw new RuntimeException("Cliente inexistente!");
        }

        return new ClienteComPedidosJson(clienteEntity.get().getNome(), clienteEntity.get().getPedidos().stream().map(PedidoEntity::getDescricao).toList());
    }

    public void deletarClienteComPedidos(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
