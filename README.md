# Sistema de Gestão de Vendas 💻📊📈
## Descrição 📝
Este é um projeto Java que realiza operações básicas de CRUD (Create, Read, Update, Delete) utilizando banco de dados relacional. O banco de dados utilizado é o MySQL e foi criado um script para a criação das tabelas e dados iniciais.

O projeto foi criado utilizando o padrão DAO (Data Access Object), que visa isolar a camada de persistência da aplicação. O objetivo do padrão DAO é centralizar e abstrair as operações realizadas com o banco de dados, diminuindo a complexidade e facilitando a manutenção da aplicação.

O projeto possui duas entidades: Seller e Department. A entidade Seller representa um vendedor e possui um relacionamento Many-to-One com a entidade Department. A entidade Department representa um departamento e pode possuir vários vendedores.

O projeto possui uma interface DAO para cada entidade, definindo as operações básicas de CRUD que podem ser realizadas com elas. As implementações dessas interfaces utilizam a biblioteca JDBC para realizar as operações com o banco de dados.

## Tecnologias utilizadas 🚀
 - Java
 - MySQL
 - JDBC
## Como utilizar 🤔
 1. Clone o repositório em sua máquina local
 2. Execute o script create_database.sql no seu banco de dados MySQL para criar as tabelas e dados iniciais
 3. Configure as informações de conexão com o banco de dados
 4. Execute o projeto através da classe App para testar a classe Seller ou a classe App2 para testar a classe Department
Você também pode criar sua própria main e fazer seus testes de ambas as classes

## Funcionalidades 👨‍💼🛍️
O sistema de gestão de vendas permite realizar as seguintes operações:

### Departamentos
 - Inserir novo departamento
 - Atualizar departamento
 - Excluir departamento
 - Encontrar departamento pelo id
 - Encontrar todos os departamentos
 - Vendedores
### Inserir novo vendedor
 - Atualizar vendedor
 - Excluir vendedor
 - Encontrar vendedor pelo id
 - Encontrar todos os vendedores
 - Encontrar vendedores pelo departamento
## Autor 👨‍💻
Este projeto foi desenvolvido por Bruno como parte do curso de Java do Nélio Alves.
