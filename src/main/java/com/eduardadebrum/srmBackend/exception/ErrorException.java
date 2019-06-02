package com.eduardadebrum.srmBackend.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Pojo para passar os erros dos campos.
 *
 * @author Eduarda de Brum Lucena
 */
@Getter
@Setter
public class ErrorException {

    private String field;
    private String messageField;
    private String globalMessage;

    public ErrorException(String field, String messageField) {
        this.field = field;
        this.messageField = messageField;
    }

    public ErrorException(String globalMessage) {
        this.globalMessage = globalMessage;
    }
}
