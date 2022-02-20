package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.repository.JogoRepository;
import br.com.letscode.moviebattle.service.JogoService;
import br.com.letscode.moviebattle.utils.ConstantesUtils;
import br.com.letscode.moviebattle.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JogoServiceImplTest {

    static final String NOME_USUARIO = TestUtils.NOME_USUARIO;;

    @Mock
    JogoRepository jogoRepository;

    @Mock
    UsuarioServiceImpl usuarioService;

    JogoService jogoService;

    Usuario user;
    Jogo jogo;

    @BeforeEach
    void setUp() {
        jogoService = new JogoServiceImpl(jogoRepository, usuarioService);
        user = TestUtils.getUsuarioMock(NOME_USUARIO);
        jogo = TestUtils.getJogoMock(user);
    }

    @Test
    void deveSucessoAoIniciarUmNovoJogo() {
        Mockito.when(usuarioService.getUsuario(Mockito.anyString())).thenReturn(user);
        Mockito.when(usuarioService.getUsernameUsuarioLogado()).thenReturn(NOME_USUARIO);
        jogoService.inicializarJogo();
        Mockito.verify(jogoRepository).save(Mockito.any(Jogo.class));
    }

    @Test
    void deveSucessoAoFinalizarUmJogo() {
        Mockito.when(usuarioService.getUsernameUsuarioLogado()).thenReturn(NOME_USUARIO);

        Mockito.when(jogoRepository.findByUsuarioUsernameAndIsFinalizadoFalse(Mockito.anyString())).thenReturn(Optional.of(jogo));

        var resultado = jogoService.finalizarJogo(jogoService.findJogoByUsuario());

        assertNotNull(resultado);
        assertEquals(ConstantesUtils.mensagemDeDespedida(jogo.getScoreFinal()), resultado);
    }

    @Test
    void deveSucessoAoAcharUmJogoAtivoPorUsuario() {
        Mockito.when(usuarioService.getUsernameUsuarioLogado()).thenReturn(NOME_USUARIO);
        Mockito.when(jogoRepository.findByUsuarioUsernameAndIsFinalizadoFalse(Mockito.anyString())).thenReturn(Optional.of(jogo));

        var jogo = jogoService.findJogoByUsuario();

        assertNotNull(jogo);
        assertTrue(jogo.getUsuario().getUsername().equals(NOME_USUARIO));
    }




}