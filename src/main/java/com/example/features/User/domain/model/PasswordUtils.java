package com.example.features.User.domain.model;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordUtils {
    public static byte[] generateSalt() {
        byte[] salt = new byte[16]; // 16 bytes (128 bits) para el salt
        new SecureRandom().nextBytes(salt);
        return salt;
    }
    public static String encryptPassword(String password, byte[] salt) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes());

            // Convert the hash to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting the password.", e);
        }
    }
}
