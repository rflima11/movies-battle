package br.com.letscode.moviebattle.repository;

import br.com.letscode.moviebattle.entities.Movie;
import br.com.letscode.moviebattle.entities.Rodada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RodadaRepository extends JpaRepository<Rodada, Long> {

    Optional<Rodada> findByUsuarioUsernameAndIsFinalizadaFalse(String usuario);

}
