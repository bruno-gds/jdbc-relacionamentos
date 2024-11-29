package com.example.jdbc_tests.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    private Long id;

    @Setter
    private String descricao;

    @Setter
    @Column("cliente_id")
    private Long clienteId;
}
