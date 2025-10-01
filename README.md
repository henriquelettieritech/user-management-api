# user-management-api

Template profissional em **Java 21 / Spring Boot** com:

- CRUD completo para usuários (name, email, password, role)
- Autenticação JWT com validação real de senha (BCrypt)
- UserDetailsService e configuração de AuthenticationProvider
- Validação com Jakarta Validation
- Documentação OpenAPI / Swagger
- PostgreSQL (configurado no docker-compose)
- pgAdmin incluído no docker-compose para facilitar testes
- Dockerfile para containerizar a aplicação

## Como rodar (modo rápido com Docker)

1. Tenha Docker & Docker Compose instalados.
2. Ajuste `src/main/resources/application.properties` se quiser alterar credenciais.
3. Suba o banco:
```bash
docker compose up -d
```
4. Build e run da aplicação localmente (ou use Dockerfile):
```bash
mvn clean package
java -jar target/user-management-api-0.0.1-SNAPSHOT.jar
```
5. Endpoints principais:
- Swagger UI: http://localhost:8080/swagger-ui.html
- Registro: POST /api/auth/register
- Login: POST /api/auth/login
- Users CRUD: /api/users (protegido — use header Authorization: Bearer <token>)
- pgAdmin: http://localhost:5050 (email: admin@local / senha: admin)

## Observações de segurança
- Troque `app.security.jwtSecret` por uma chave forte e use variáveis de ambiente.
- Em produção, ajuste CORS, HTTPS e tratamento de erros.
