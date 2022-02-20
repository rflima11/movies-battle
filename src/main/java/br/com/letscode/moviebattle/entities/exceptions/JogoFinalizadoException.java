package br.com.letscode.moviebattle.entities.exceptions;

public class JogoFinalizadoException extends RuntimeException {

    private long scoreFinal;

    public JogoFinalizadoException(String msg, Long scoreFinal) {
        super(msg + " " + scoreFinal);

    }

    public long getScoreFinal() {
        return scoreFinal;
    }
}