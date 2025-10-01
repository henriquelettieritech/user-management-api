package henriquelettieritech.usermanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "User Management API", version = "1.0",
        description = "Gestão de Usuários com Spring Boot, JWT, Swagger e PostgreSQL"))
@SpringBootApplication
public class UserManagementApplication {
  public static void main(String[] args) {
    SpringApplication.run(UserManagementApplication.class, args);
  }
}
