package br.com.letscode.moviebattle.config;

import br.com.letscode.moviebattle.entities.exceptions.JogoFinalizadoException;
import br.com.letscode.moviebattle.entities.exceptions.PartidaNaoIniciadaException;
import br.com.letscode.moviebattle.openapi.model.Mensagem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem genericHandler(Exception e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(JogoFinalizadoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem jogoFinalizadoHandler(JogoFinalizadoException e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

    @ResponseBody
    @ExceptionHandler(PartidaNaoIniciadaException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Mensagem partidaNaoIniciadaHandler(PartidaNaoIniciadaException e) {
        var msg = new Mensagem();
        msg.setMsg(e.getMessage());
        return msg;
    }

}
