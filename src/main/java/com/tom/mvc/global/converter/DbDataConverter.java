package com.tom.mvc.global.converter;

import com.tom.mvc.global.config.DbConfig;
import com.tom.mvc.global.util.Aes256Util;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Converter
@Component
@RequiredArgsConstructor
public class DbDataConverter implements AttributeConverter<String, String> {
    private final DbConfig dbConfig;

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return Aes256Util.encrypt(attribute, dbConfig.getSecretKey(), dbConfig.getIv());
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return Aes256Util.decrypt(dbData, dbConfig.getSecretKey(), dbConfig.getIv());
    }
}
