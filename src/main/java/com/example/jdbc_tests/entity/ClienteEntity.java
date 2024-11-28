package com.example.jdbc_tests.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table(name = "clientes")
public class ClienteEntity {
    @Id
    private Long id;
    private String nome;

    @MappedCollection(idColumn = "cliente_id")
    private Set<PedidoEntity> pedidos;


    public ClienteEntity() {}

    public ClienteEntity(String nome, Set<PedidoEntity> pedidos) {
        this.nome = nome;
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<PedidoEntity> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<PedidoEntity> pedidos) {
        this.pedidos = pedidos;
    }
}