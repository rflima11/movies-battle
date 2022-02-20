package br.com.letscode.moviebattle.repository;

import br.com.letscode.moviebattle.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    Optional<Jogo> findByUsuarioUsernameAndIsFinalizadoFalse(String usuario);

}
