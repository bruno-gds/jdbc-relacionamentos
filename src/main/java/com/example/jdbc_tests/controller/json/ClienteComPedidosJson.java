package com.example.jdbc_tests.controller.json;

import lombok.Builder;

import java.util.List;

@Builder
public record ClienteComPedidosJson(
        String nome,
        List<String> pedidos
) {
}
