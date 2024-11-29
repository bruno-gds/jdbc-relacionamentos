package com.example.jdbc_tests.repository;

import com.example.jdbc_tests.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteEntity, Long> {
    List<ClienteEntity> findAll();
}
