package br.com.letscode.moviebattle.entities.exceptions;

public class SameMovieException extends RuntimeException {

    public SameMovieException(String msg) {
        super(msg);
    }
}
