package br.com.letscode.moviebattle.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class JogoRepositoryTest {

    final JogoRepository jogoRepository;

    JogoRepositoryTest(JogoRepository jogoRepository) {
        this.jogoRepository = jogoRepository;
    }
}