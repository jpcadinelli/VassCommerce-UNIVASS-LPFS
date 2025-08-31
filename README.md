# 🛒 VassCommerce API

O **VassCommerce** é um serviço web que simula um pequeno sistema de e-commerce.  
Ele foi desenvolvido como exercício de estudo em **Java**, com base no diagrama de classes fornecido.  
A API contempla funcionalidades típicas de plataformas de comércio eletrônico, como cadastro de clientes, gerenciamento de produtos, pedidos e pagamentos.

---

## 📌 Funcionalidades Principais

- **Cadastro de Clientes**
    - Registro de informações pessoais (CPF, data de nascimento, foto, etc.)
    - Associação de endereços e cartões de pagamento

- **Gerenciamento de Produtos**
    - Produtos vinculados a categorias
    - Cada categoria possui um **administrador responsável**
    - Apenas o administrador da categoria pode cadastrar novos produtos

- **Pedidos**
    - Criação de pedidos contendo múltiplos itens
    - Cálculo de valor total do pedido
    - Controle de status do pedido (aguardando pagamento, separando estoque, entregue à transportadora, entregue ao cliente)

- **Pagamentos**
    - Um pedido pode ser pago com **vários cartões**
    - Cada cartão pertence a um cliente e pode ser do tipo **crédito** ou **débito**
    - Possibilidade de dividir o pagamento entre diferentes cartões

- **Promoções**
    - Administração de tabelas de promoções
    - Cada promoção tem período de validade (data início e fim)
    - Produtos podem participar de várias promoções; **o menor preço sempre será considerado**
    - Qualquer administrador pode cadastrar novas promoções

---

## 📊 Diagrama de Classes

O sistema foi modelado a partir do seguinte diagrama de classes de análise:

![Diagrama de Classes](./docs/diagrama.png)

> O diagrama representa os relacionamentos entre clientes, usuários, pedidos, produtos, categorias, promoções e administradores.

---

## 🏗️ Estrutura da API

### Entidades Principais
- **Cliente**
- **Usuário**
- **Administrador**
- **Produto**
- **Categoria**
- **Pedido**
- **ItemPedido**
- **Pagamento**
- **Cartão** / **TipoCartão**
- **TabelaPromoção** / **PromoçãoItem**
- **Endereço** / **Cidade** / **Estado**

---

## ⚙️ Tecnologias Utilizadas

- **Java 21+**
- **Spring Boot**
- **Maven**
- **JUnit**

---

## 🚀 Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/jpcadinelli/VassCommerce-UNIVASS-LPFS.git

2. Acesse o diretório do projeto:
   ```bash 
   cd vasscommerce

3. Configure o banco de dados no arquivo application.properties.

4. Execute a aplicação:
  ``` bash
  mvn spring-boot:run