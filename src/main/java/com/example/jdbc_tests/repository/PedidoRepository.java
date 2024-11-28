package com.example.jdbc_tests.repository;

import com.example.jdbc_tests.entity.PedidoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<PedidoEntity, Long> {
}
