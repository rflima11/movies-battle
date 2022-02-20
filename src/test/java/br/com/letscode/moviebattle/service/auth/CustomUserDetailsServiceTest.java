package br.com.letscode.moviebattle.service.auth;

import br.com.letscode.moviebattle.entities.Usuario;
import br.com.letscode.moviebattle.repository.UsuarioRepository;
import br.com.letscode.moviebattle.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailsServiceTest {

    static final String NOME_USUARIO = TestUtils.NOME_USUARIO;

    @Mock
    UsuarioRepository usuarioRepository;

    UserDetailsService customUserDetails;

    Usuario usuario;

    @BeforeEach
    void setUp() {
        customUserDetails = new CustomUserDetailsService(usuarioRepository);
        usuario = TestUtils.getUsuarioMock(NOME_USUARIO);
    }

    @Test
    void deveSucessoAoCarregarUmUsuarioPeloUsername() {
        Mockito.when(usuarioRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(usuario));
        var userDetails = customUserDetails.loadUserByUsername(NOME_USUARIO);

        assertEquals(usuario.getUsername(), userDetails.getUsername());
        assertEquals(usuario.getSenha(), userDetails.getPassword());
    }

}