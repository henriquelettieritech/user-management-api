package henriquelettieritech.usermanagement.dto;

import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthRequest {
  @NotBlank
  @Email
  private String email;

  @NotBlank
  private String password;
}
