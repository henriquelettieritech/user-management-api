package henriquelettieritech.usermanagement.controller;

import henriquelettieritech.usermanagement.dto.AuthRequest;
import henriquelettieritech.usermanagement.dto.AuthResponse;
import henriquelettieritech.usermanagement.dto.UserRequest;
import henriquelettieritech.usermanagement.dto.UserResponse;
import henriquelettieritech.usermanagement.model.User;
import henriquelettieritech.usermanagement.security.JwtUtils;
import henriquelettieritech.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserService userService;
  private final JwtUtils jwtUtils;
  private final AuthenticationManager authenticationManager;

  public AuthController(UserService userService, JwtUtils jwtUtils, AuthenticationManager authenticationManager) {
    this.userService = userService;
    this.jwtUtils = jwtUtils;
    this.authenticationManager = authenticationManager;
  }

  @PostMapping("/register")
  public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRequest req) {
    if (userService.findByEmail(req.getEmail()).isPresent()) {
      return ResponseEntity.badRequest().build();
    }
    User u = userService.create(req);
    UserResponse resp = UserResponse.builder()
            .id(u.getId())
            .name(u.getName())
            .email(u.getEmail())
            .role(u.getRole())
            .build();
    return ResponseEntity.ok(resp);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
    try {
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
      String token = jwtUtils.generateJwtToken(req.getEmail());
      return ResponseEntity.ok(AuthResponse.builder().token(token).build());
    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(401).build();
    } catch (Exception ex) {
      return ResponseEntity.status(500).build();
    }
  }
}
