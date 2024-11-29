package com.example.jdbc_tests.service;

import com.example.jdbc_tests.controller.json.ClienteComPedidosJson;
import com.example.jdbc_tests.entity.ClienteEntity;
import com.example.jdbc_tests.entity.PedidoEntity;
import com.example.jdbc_tests.repository.ClienteRepository;
import com.example.jdbc_tests.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    public ClienteService(ClienteRepository clienteRepository, PedidoRepository pedidoRepository) {
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public List<ClienteComPedidosJson> listarTodosClientesComPedidos() {
        var clientesEntity = clienteRepository.findAll();

        return clientesEntity.stream().map(cliente -> ClienteComPedidosJson.builder()
                .nome(cliente.getNome())
                .pedidos(cliente.getPedidos().stream().map(PedidoEntity::getDescricao).toList())
                .build()).toList();
    }

    public ClienteComPedidosJson obterClienteComPedidos(Long clienteId) {
        var clienteEntity = clienteRepository.findById(clienteId);

        if (clienteEntity.isEmpty()) {
            throw new RuntimeException("Cliente inexistente!");
        }

        return ClienteComPedidosJson.builder()
                .nome(clienteEntity.get().getNome())
                .pedidos(clienteEntity.get().getPedidos().stream().map(PedidoEntity::getDescricao).toList())
                .build();
    }

    public Long salvarClienteComPedidos(ClienteComPedidosJson clienteComPedidosJson) {
        var clienteEntity = ClienteEntity.builder()
                .nome(clienteComPedidosJson.nome())
                .build();
        var clienteEntityAdicionado = clienteRepository.save(clienteEntity);

        List<PedidoEntity> pedidos = clienteComPedidosJson.pedidos().stream()
                .map(descricao -> PedidoEntity.builder()
                        .descricao(descricao)
                        .clienteId(clienteEntityAdicionado.getId())
                        .build()).toList();
        pedidoRepository.saveAll(pedidos);

        return clienteEntityAdicionado.getId();
    }

    public void deletarClienteComPedidos(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
