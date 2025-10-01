package henriquelettieritech.usermanagement.controller;

import henriquelettieritech.usermanagement.dto.UserRequest;
import henriquelettieritech.usermanagement.dto.UserResponse;
import henriquelettieritech.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<UserResponse>> listAll() {
    var list = service.findAll().stream().map(u -> UserResponse.builder()
            .id(u.getId())
            .name(u.getName())
            .email(u.getEmail())
            .role(u.getRole())
            .build()).collect(Collectors.toList());
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
    return service.findById(id).map(u -> UserResponse.builder()
            .id(u.getId())
            .name(u.getName())
            .email(u.getEmail())
            .role(u.getRole())
            .build())
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest req) {
    if (service.findByEmail(req.getEmail()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    var created = service.create(req);
    var resp = UserResponse.builder().id(created.getId()).name(created.getName()).email(created.getEmail()).role(created.getRole()).build();
    return ResponseEntity.created(URI.create("/api/users/" + resp.getId())).body(resp);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserRequest req) {
    var updated = service.update(id, req);
    var resp = UserResponse.builder().id(updated.getId()).name(updated.getName()).email(updated.getEmail()).role(updated.getRole()).build();
    return ResponseEntity.ok(resp);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
