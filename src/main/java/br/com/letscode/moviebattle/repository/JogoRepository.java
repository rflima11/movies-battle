package br.com.letscode.moviebattle.repository;

import br.com.letscode.moviebattle.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
