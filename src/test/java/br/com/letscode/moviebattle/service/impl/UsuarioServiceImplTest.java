package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.repository.UsuarioRepository;
import br.com.letscode.moviebattle.service.UsuarioService;
import br.com.letscode.moviebattle.service.auth.CustomUserDetail;
import br.com.letscode.moviebattle.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    final String NOME_USUARIO = TestUtils.NOME_USUARIO;

    @Mock
    UsuarioRepository usuarioRepository;

    UsuarioService usuarioService;

    Usuario usuario;

    @BeforeEach
    void setUp() {
        usuarioService = new UsuarioServiceImpl(usuarioRepository);
        usuario = TestUtils.getUsuarioMock(NOME_USUARIO);
    }

    @Test
    void deveSucessoAoBuscarUmUsuarioPeloUsername() {
        Mockito.when(usuarioRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(usuario));

        var usuario = usuarioService.getUsuario(NOME_USUARIO);

        assertNotNull(usuario);
        assertInstanceOf(Usuario.class, usuario);
    }

    @Test
    void deveSucessoAoBuscarUmUsuarioLogado() {
        mockAuthContext();
        var username = usuarioService.getUsernameUsuarioLogado();

        assertNotNull(username);
        assertEquals(usuario.getUsername(), username);
    }

    private void mockAuthContext() {
        var authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(authentication.getPrincipal()).thenReturn(new CustomUserDetail(usuario));
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

}