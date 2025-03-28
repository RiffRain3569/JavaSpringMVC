package com.tom.mvc.global.util;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class JwtPayloadUtil {
    public static Map<String, String> dtoToClaim(Object dto) {
        Map<String, String> map = new HashMap<>();
        try {
            for (Field field : dto.getClass().getDeclaredFields()) {
                field.setAccessible(true); // private 필드 접근 허용
                Object value = field.get(dto);
                if (value != null) {
                    map.put(field.getName(), value.toString());
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to convert DTO to Map", e);
        }
        return map;
    }

}
