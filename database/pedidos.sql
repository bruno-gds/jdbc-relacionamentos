CREATE TABLE `pedidos` (
    `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `descricao` VARCHAR(255) NOT NULL,
    `cliente_id` BIGINT NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);