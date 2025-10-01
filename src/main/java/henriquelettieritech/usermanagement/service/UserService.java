package henriquelettieritech.usermanagement.service;

import henriquelettieritech.usermanagement.dto.UserRequest;
import henriquelettieritech.usermanagement.model.User;
import henriquelettieritech.usermanagement.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
    this.repository = repository;
    this.passwordEncoder = passwordEncoder;
  }

  public User create(UserRequest req) {
    User u = User.builder()
            .name(req.getName())
            .email(req.getEmail())
            .password(passwordEncoder.encode(req.getPassword()))
            .role("ROLE_USER")
            .build();
    return repository.save(u);
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public Optional<User> findById(Long id) {
    return repository.findById(id);
  }

  public Optional<User> findByEmail(String email) {
    return repository.findByEmail(email);
  }

  public User update(Long id, UserRequest req) {
    User u = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    u.setName(req.getName());
    u.setEmail(req.getEmail());
    if (req.getPassword() != null && !req.getPassword().isBlank()) {
      u.setPassword(passwordEncoder.encode(req.getPassword()));
    }
    return repository.save(u);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
