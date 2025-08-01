package com.metaphorce.CineMagic.converters;
import com.metaphorce.CineMagic.enums.MedioPago;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MedioPagoConverter implements AttributeConverter<MedioPago, String> {

    @Override
    public String convertToDatabaseColumn(MedioPago medioPago) {
        return medioPago != null ? medioPago.name() : null;
    }

    @Override
    public MedioPago convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return MedioPago.from(dbData);
    }
}
