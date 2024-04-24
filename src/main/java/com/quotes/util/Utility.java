package com.quotes.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import javax.crypto.Cipher;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Random;

/**
 * Created by Mohit Tyagi on 05-02-2024
 *
 * @author: Mohit Tyagi
 * @date: 05-02-2024
 * @project: all-in-one
 */

@Service
public class Utility {

//    private final Cipher encryptCipher;
//    private final Cipher decryptCipher;
//
//    public Utility(Cipher encryptCipher, Cipher decryptCipher) {
//        this.encryptCipher = encryptCipher;
//        this.decryptCipher = decryptCipher;
//    }

    public String getUrlPath() {
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        URI newUri = builder.build().toUri();
        return newUri.getPath();
    }

//    public String getLoggedInUser(){
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String username = null;
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails)principal).getUsername();
//        } else {
//            username = principal.toString();
//        }
//        return username;
//    }
//
//    public byte[] encrypt(String data) throws Exception {
//        return encryptCipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
//    }
//
//    public String decrypt(String encryptedData) throws Exception {
//        byte[] decryptedBytes = decryptCipher.doFinal(Base64.decodeBase64(encryptedData));
//        return new String(decryptedBytes, StandardCharsets.UTF_8);
//    }

    public int generateOtp(){
        Random generator = new Random();
        return 100000 + generator.nextInt(900000);
    }

    public Map<String, ?> getLoggedInUserDetails(){
        return null;
    }
}
