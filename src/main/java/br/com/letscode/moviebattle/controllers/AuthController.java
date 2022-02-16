package br.com.letscode.moviebattle.controllers;

import br.com.letscode.moviebattle.entities.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @PostMapping(path = "/auth")
  public void autenticarUsuario(@RequestBody Usuario usuario) {

  }

}
