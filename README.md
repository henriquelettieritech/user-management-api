# User Management API

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker)
![Swagger](https://img.shields.io/badge/Swagger-API%20Docs-green?style=for-the-badge&logo=swagger)

> 🚀 Template profissional em **Java 21 + Spring Boot** para gestão de usuários com autenticação JWT e PostgreSQL.

---

## ✨ Funcionalidades

- ✅ CRUD completo para usuários (`name`, `email`, `password`, `role`)  
- 🔐 Autenticação JWT com validação real de senha (BCrypt)  
- 👤 Implementação de `UserDetailsService` e `AuthenticationProvider`  
- 🛡️ Validação com Jakarta Validation  
- 📖 Documentação com OpenAPI / Swagger  
- 🐘 PostgreSQL configurado via **docker-compose**  
- 📊 pgAdmin incluído para facilitar testes  
- 🐳 Dockerfile para containerizar a aplicação  

---

## ⚡ Como rodar (modo rápido com Docker)

1. Instale **Docker** e **Docker Compose**.  
2. Ajuste credenciais em `src/main/resources/application.properties` (se necessário).  
3. Suba o banco e o pgAdmin:  
   ```bash
   docker compose up -d
   ```
4. Compile e execute a aplicação (local ou via Docker):  
   ```bash
   mvn clean package
   java -jar target/user-management-api-0.0.1-SNAPSHOT.jar
   ```
5. Endpoints principais:
   - Swagger UI → [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
   - Registro → `POST /api/auth/register`  
   - Login → `POST /api/auth/login`  
   - Users CRUD → `/api/users` (🔒 protegido — use `Authorization: Bearer <token>`)  
   - pgAdmin → [http://localhost:5050](http://localhost:5050) (login: `admin@local` / senha: `admin`)  

---

## 🔒 Observações de Segurança

- Sempre altere `app.security.jwtSecret` para uma chave forte e utilize variáveis de ambiente.  
- Em produção, configure:
  - ✅ HTTPS  
  - ✅ Regras de CORS  
  - ✅ Tratamento de erros customizado  

---

## 👨‍💻 Autor

**Henrique Lettieri**  
[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/henrique-lettieri-10b83935a)  
[![GitHub](https://img.shields.io/badge/GitHub-black?style=flat&logo=github)](https://github.com/henriquelettieritech)
