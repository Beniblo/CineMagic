package com.metaphorce.CineMagic.converters;

import com.metaphorce.CineMagic.enums.Formato;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FormatoConverter implements AttributeConverter<Formato, String> {

    @Override
    public String convertToDatabaseColumn(Formato formato) {
        if (formato == null) return null;
        return formato.getLabel();
    }

    @Override
    public Formato convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        for (Formato f : Formato.values()) {
            if (f.getLabel().equalsIgnoreCase(dbData)) {
                return f;
            }
        }
        throw new IllegalArgumentException("Formato desconocido: " + dbData);
    }
}

