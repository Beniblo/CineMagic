package com.metaphorce.CineMagic.converters;
import com.metaphorce.CineMagic.enums.NumeroFila;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class NumeroFilaConverter implements AttributeConverter<NumeroFila, String> {

    @Override
    public String convertToDatabaseColumn(NumeroFila numeroFila) {
        return numeroFila != null ? numeroFila.getValor() : null;
    }

    @Override
    public NumeroFila convertToEntityAttribute(String valor) {
        return NumeroFila.from(valor);
    }
}
