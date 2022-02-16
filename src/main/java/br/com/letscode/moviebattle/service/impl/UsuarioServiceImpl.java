package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.repository.UsuarioRepository;
import br.com.letscode.moviebattle.service.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario salvarNovoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
