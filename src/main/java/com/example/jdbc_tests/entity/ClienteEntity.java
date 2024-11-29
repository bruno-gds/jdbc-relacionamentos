package com.example.jdbc_tests.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    private Long id;

    @Setter
    private String nome;

    @Setter
    @MappedCollection(idColumn = "cliente_id")
    private Set<PedidoEntity> pedidos;
}