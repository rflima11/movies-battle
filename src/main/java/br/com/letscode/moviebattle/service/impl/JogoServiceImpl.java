package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.service.JogoService;
import org.springframework.stereotype.Service;

@Service
public class JogoServiceImpl implements JogoService {

    @Override
    public void inicializarJogo(Usuario usuario) {
        new Jogo(usuario);
    }
}
