package com.example.jdbc_tests.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    private Long id;
    private String descricao;

    @Column("cliente_id")
    private Long clienteId;


    public PedidoEntity() {}

    public PedidoEntity(String descricao, Long clienteId) {
        this.descricao = descricao;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
}
