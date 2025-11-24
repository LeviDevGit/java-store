# 📦 API de Gestão de Vendas (Order Management)

Esta é uma **API RESTful** desenvolvida para gerenciar o fluxo de pedidos de venda, incluindo cadastro de clientes, catálogo de produtos e associação de itens aos pedidos.

---

## 🚀 Visão Geral

A aplicação é estruturada em torno de quatro entidades principais:

- **tb_client**: Gerenciamento completo de clientes.
- **tb_product**: Gerenciamento de catálogo de produtos.
- **tb_order**: Criação e consulta de pedidos (cabeçalho).
- **tb_order-products**: Gerenciamento dos itens (produtos) dentro de cada pedido.

---

## 📚 Endpoints

### 👤 Clientes (`/clients`)

Gerencia criação, listagem, atualização e exclusão de clientes.

| Método | Rota | Descrição |
|--------|------|-----------|
| GET    | /clients | Retorna todos os clientes. |
| GET    | /clients/{id} | Retorna um cliente específico pelo ID. |
| POST   | /clients | Cadastra um novo cliente. |
| PATCH  | /clients/{id} | Atualiza parcialmente os dados de um cliente (ex: telefone, email). |
| DELETE | /clients/{id} | Remove um cliente do sistema. |

**Nota sobre erros:** Existem testes para cenários de falha, como buscar/atualizar/deletar um ID inexistente (`ID ERROR`) ou enviar dados inválidos (`ERROR`).

---

### 🏷️ Produtos (`/products`)

Gerencia o catálogo de produtos disponíveis para venda.

| Método | Rota | Descrição |
|--------|------|-----------|
| GET    | /products | Lista todos os produtos cadastrados. |
| GET    | /products/{id} | Retorna detalhes de um produto específico. |
| POST   | /products | Cria um novo produto. |
| PATCH  | /products/{id} | Atualiza dados do produto (ex: preço, descrição). |
| DELETE | /products/{id} | Remove um produto do catálogo. |

---

### 🛒 Pedidos (`/orders`)

Gerencia o registro de pedidos, geralmente vinculando um cliente e registrando uma data.

| Método | Rota | Descrição |
|--------|------|-----------|
| GET    | /orders | Lista todos os pedidos realizados. |
| POST   | /orders | Cria um novo pedido. |

---

### 🧾 Itens do Pedido (`/order-products`)

Gerencia a associação de produtos a pedidos existentes.

| Método | Rota | Descrição |
|--------|------|-----------|
| GET    | /order-products | Lista todos os itens de pedidos registrados. |
| GET    | /order-products/{id} | Retorna um vínculo específico de item de pedido. |
| POST   | /order-products | Adiciona um item (produto) a um pedido. |
| DELETE | /order-products/{id} | Remove um item de um pedido. |

---
