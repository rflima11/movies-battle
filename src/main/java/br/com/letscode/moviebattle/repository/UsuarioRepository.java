package br.com.letscode.moviebattle.repository;

import br.com.letscode.moviebattle.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String usuario);

    @Query(value = "SELECT RANK() OVER (ORDER BY u.MELHOR_SCORE DESC) posicao, * FROM Usuario u ORDER BY posicao", nativeQuery = true)
    List<Usuario> getRanking();

}
