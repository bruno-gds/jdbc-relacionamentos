package com.example.jdbc_tests.controller.json;

import java.util.List;

public record ClienteComPedidosJson(
        String nome,
        List<String> pedidos
) {
}
