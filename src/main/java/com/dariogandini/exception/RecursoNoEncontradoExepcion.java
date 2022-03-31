package com.dariogandini.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoExepcion extends Exception {
    private static final long serialVersionUID = 1L;

    public RecursoNoEncontradoExepcion(String mensaje) {
        super(mensaje);
    }
}
