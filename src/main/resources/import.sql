INSERT INTO tb_client (nome, email, telefone) VALUES ('Ana Souza', 'ana.souza@example.com', '(11) 91234-5678');
INSERT INTO tb_client (nome, email, telefone) VALUES ('Bruno Lima', 'bruno.lima@example.com', '(21) 99876-5432');
INSERT INTO tb_client (nome, email, telefone) VALUES ('Carlos Ribeiro', 'carlos.ribeiro@example.com', '(31) 98765-4321');
INSERT INTO tb_client (nome, email, telefone) VALUES ('Daniela Alves', 'daniela.alves@example.com', '(41) 97654-3210');
INSERT INTO tb_client (nome, email, telefone) VALUES ('Eduardo Martins', 'eduardo.martins@example.com', '(51) 96543-2109');

INSERT INTO tb_product (nome, descricao, preco, estoque) VALUES ('Mouse Gamer', 'Mouse óptico com RGB', 149.90, 120);
INSERT INTO tb_product (nome, descricao, preco, estoque) VALUES ('Teclado Mecânico', 'Switches azuis e backlight', 329.50, 80);
INSERT INTO tb_product (nome, descricao, preco, estoque) VALUES ('Monitor 27"', 'Quad HD 165 Hz', 1899.00, 35);
INSERT INTO tb_product (nome, descricao, preco, estoque) VALUES ('Headset Wireless', 'Som surround 7.1', 599.90, 60);
INSERT INTO tb_product (nome, descricao, preco, estoque) VALUES ('Webcam Full HD', 'Microfone embutido', 249.00, 50);

INSERT INTO tb_order (client_id, data_pedido, status, total) VALUES (1, '2025-11-20 09:30:00', 'PENDENTE', 479.40);
INSERT INTO tb_order (client_id, data_pedido, status, total) VALUES (2, '2025-11-21 14:15:00', 'PROCESSANDO', 1899.00);
INSERT INTO tb_order (client_id, data_pedido, status, total) VALUES (3, '2025-11-22 18:45:00', 'ENVIADO', 778.40);

INSERT INTO tb_order_item (order_id, product_id, quantidade) VALUES (1, 1, 2);
INSERT INTO tb_order_item (order_id, product_id, quantidade) VALUES (1, 2, 1);
INSERT INTO tb_order_item (order_id, product_id, quantidade) VALUES (2, 3, 1);
INSERT INTO tb_order_item (order_id, product_id, quantidade) VALUES (3, 4, 1);
INSERT INTO tb_order_item (order_id, product_id, quantidade) VALUES (3, 5, 2);