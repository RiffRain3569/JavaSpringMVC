package com.tom.mvc.global.util;

import org.jasypt.util.text.AES256TextEncryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.web.WebAppConfiguration;

//@SpringBootTest
@WebAppConfiguration
class JasyptTest {

    @Test
    void jasypt_test() {
        String plaintText = "0123456789";
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword("TEST");

        String encryptText = encryptor.encrypt(plaintText);
        System.out.println(encryptText);
        String decryptText = encryptor.decrypt(encryptText);
        System.out.println(decryptText);
        Assertions.assertEquals(plaintText, decryptText);

    }

}
