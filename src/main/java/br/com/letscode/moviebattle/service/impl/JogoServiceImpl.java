package br.com.letscode.moviebattle.service.impl;

import br.com.letscode.moviebattle.entities.Jogo;
import br.com.letscode.moviebattle.entities.exceptions.PartidaNaoIniciadaException;
import br.com.letscode.moviebattle.repository.JogoRepository;
import br.com.letscode.moviebattle.service.JogoService;
import br.com.letscode.moviebattle.service.UsuarioService;
import br.com.letscode.moviebattle.utils.ConstantesUtils;
import org.springframework.stereotype.Service;

@Service
public class JogoServiceImpl implements JogoService {

    private final JogoRepository jogoRepository;
    private final UsuarioService usuarioService;

    public JogoServiceImpl(JogoRepository jogoRepository, UsuarioService usuarioService) {
        this.jogoRepository = jogoRepository;
        this.usuarioService = usuarioService;
    }

    @Override
    public void inicializarJogo() {
     salvarJogo(new Jogo(usuarioService.getUsuario(usuarioService.getUsernameUsuarioLogado())));
    }

    @Override
    public Jogo findJogoByUsuario() {
        return jogoRepository.findByUsuarioUsernameAndIsFinalizadoFalse(usuarioService.getUsernameUsuarioLogado())
                .orElseThrow(() -> new PartidaNaoIniciadaException("Não há nenhuma partida em andamento"));
    }

    @Override
    public String finalizarJogo(Jogo jogo) {
        jogo.setFinalizado(true);
        atualizarScoreFinal(jogo);
        salvarJogo(jogo);
        return ConstantesUtils.mensagemDeDespedida(jogo.getScoreFinal());
    }

    private void atualizarScoreFinal(Jogo jogo) {
        var scoreFinal = jogo.calcularPontuacaoFinal();
        jogo.setScoreFinal(scoreFinal);
        var melhorScoreUsuario = jogo.getUsuario().getMelhorScore();
        if (melhorScoreUsuario < scoreFinal) {
            jogo.getUsuario().setMelhorScore((Double.parseDouble(String.valueOf(scoreFinal))));
        }
    }

    private Jogo salvarJogo(Jogo jogo) {
        return jogoRepository.save(jogo);
    }


}
