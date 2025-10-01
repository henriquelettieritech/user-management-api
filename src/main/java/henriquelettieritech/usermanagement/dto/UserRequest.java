package henriquelettieritech.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequest {
  @NotBlank
  @Size(min = 2, max = 100)
  private String name;

  @NotBlank
  @Email
  private String email;

  @NotBlank
  @Size(min = 6)
  private String password;
}
