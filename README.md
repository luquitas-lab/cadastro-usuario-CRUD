# API de Cadastro de Usuários

## 🛠️ Tecnologias Utilizadas
- **Java 25**
- **Spring Boot 4.0.7**
- **Spring Data JPA**
- **H2 Database**
- **Lombok**
- **Maven**

## Arquitetura
O projeto segue a arquitetura em camadas (MVC/REST):
- `Controller`: Ponto de entrada da API, recebe e responde requisições HTTP (`UsuarioController`).
- `Service`: Regras de negócio, manipulação e orquestração de dados (`UsuarioService`).
- `Repository`: Interface de acesso e operações no banco de dados (`UsuarioRepository`).
- `Entity`: Representação estrutural da tabela no banco de dados (`Usuario`).

## Como Executar

1. Clone este repositório.
2. Certifique-se de ter o Java 25 e o Maven instalados.
3. Importe o projeto em sua IDE.
4. Execute a classe principal `CadastroUsuarioApplication.java`.
5. A aplicação estará rodando na porta **8081**.

## Endpoints da API

A API possui a rota base `/usuario`.

| Método | Rota | Descrição | Parâmetros / Body (JSON) |
|---|---|---|---|
| **POST** | `/usuario` | Cria um novo usuário | Body: `{"name": "...", "email": "..."}` |
| **GET** | `/usuario?email={email}` | Busca um usuário pelo e-mail | Query Param: `email` |
| **PUT** | `/usuario?id={id}` | Atualiza um usuário existente | Query Param: `id` <br> Body: Novos dados |
| **DELETE** | `/usuario?email={email}` | Exclui um usuário pelo e-mail | Query Param: `email` |

## Acesso ao Banco de Dados (H2 Console)

O banco de dados utilizado é o H2 (em memória). Para inspecionar as tabelas e dados salvos:
1. Com a aplicação rodando, acesse no navegador: `http://localhost:8081/h2-console`
2. Preencha as credenciais na tela de login:
   - **Driver Class:** `org.h2.Driver`
   - **JDBC URL:** `jdbc:h2:mem:usuariodb`
   - **User Name:** `sa`
   - **Password:** *(deixe totalmente em branco)*
3. Clique em **Connect**.

## 📋 Estrutura da Entidade (JSON)
Exemplo do modelo de dados esperado e retornado pela API:
```json
{
  "id": 1,
  "name": "Nome do Usuário",
  "email": "email@exemplo.com"
}
```
