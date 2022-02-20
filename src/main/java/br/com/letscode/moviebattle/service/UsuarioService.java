package br.com.letscode.moviebattle.service;

import br.com.letscode.moviebattle.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario getUsuario(String string);

    List<Usuario> getRanking();

    String getUsernameUsuarioLogado();
}
