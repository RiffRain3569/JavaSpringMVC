package com.tom.mvc.global.converter;

import com.tom.mvc.global.util.Aes256Util;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Converter
@Component
public class DbDataConverter implements AttributeConverter<String, String> {

    @Value("${project.db.crypt.secret-key}")
    private String SECRET_KEY;

    @Value("${project.db.crypt.iv}")
    private String IV;


    @Override
    public String convertToDatabaseColumn(String attribute) {
        return Aes256Util.encrypt(attribute, SECRET_KEY, IV);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return Aes256Util.decrypt(dbData, SECRET_KEY, IV);
    }
}
