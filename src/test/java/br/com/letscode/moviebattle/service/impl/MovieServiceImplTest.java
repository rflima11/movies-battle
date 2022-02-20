package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.repository.MovieRepository;
import br.com.letscode.moviebattle.service.MovieService;
import br.com.letscode.moviebattle.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(MockitoExtension.class)
class MovieServiceImplTest {

    static final String NOME_USUARIO = TestUtils.NOME_USUARIO;

    @Mock
    MovieRepository movieRepository;

    MovieService movieService;

    Usuario user;
    Jogo jogo;

    @BeforeEach
    void setUp() {
        user = TestUtils.getUsuarioMock(NOME_USUARIO);
        jogo = TestUtils.getJogoMock(user);
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Test
    void deveSucessoAoBuscarDoisFilmesAleatorios() {
        Mockito.when(movieRepository.findAll()).thenReturn(TestUtils.getQuarentaFilmes());

        var filmesAleatorios = movieService.getTwoRandomMovies(jogo);

        assertNotEquals(filmesAleatorios.get(0).getId(), filmesAleatorios.get(1).getId());
        assertNotEquals(filmesAleatorios.get(0).getRating(), filmesAleatorios.get(1).getRating());
        assertEquals(filmesAleatorios.size(), 2);
    }

}