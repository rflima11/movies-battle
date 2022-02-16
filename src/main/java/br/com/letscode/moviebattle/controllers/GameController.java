package br.com.letscode.moviebattle.controllers;

import br.com.letscode.moviebattle.entities.Rodada;
import br.com.letscode.moviebattle.service.RodadasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

    private final RodadasService startRoundUseCase;

    public GameController(RodadasService startRoundUseCase) {
        this.startRoundUseCase = startRoundUseCase;
    }

    @GetMapping("/start")
    public ResponseEntity<Rodada> startRound() {
        return ResponseEntity.status(HttpStatus.OK).body(startRoundUseCase.incializarRodada());
    }


}
