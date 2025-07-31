package com.metaphorce.CineMagic.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SalaConverter implements AttributeConverter<Sala, String> {

    @Override
    public String convertToDatabaseColumn(Sala sala) {
        if (sala == null) {
            return null;
        }
        return sala.getLabel();
    }

    @Override
    public Sala convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Sala.fromLabel(dbData);
    }
}
