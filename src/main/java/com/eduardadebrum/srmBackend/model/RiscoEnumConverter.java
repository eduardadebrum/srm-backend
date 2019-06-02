package com.eduardadebrum.srmBackend.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;
import java.util.Objects;

/**
 * Classe responsavél por converter os valores do banco para um enumerador e do
 * enumerador para o banco.
 *
 * @author Eduarda de Brum Lucena
 */
@Convert
public class RiscoEnumConverter implements AttributeConverter<RiscoEnum, String> {

    @Override
    public String convertToDatabaseColumn(RiscoEnum riscoEnum) {
        return Objects.nonNull(riscoEnum) ? riscoEnum.name() : null;
    }

    @Override
    public RiscoEnum convertToEntityAttribute(String value) {
        return Objects.isNull(value) || value.trim().equals("") ? null : RiscoEnum.valueOf(value);
    }
}
