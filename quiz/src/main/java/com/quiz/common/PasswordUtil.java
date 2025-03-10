package com.quiz.common;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Hash a password before storing it in the database
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12)); // 12 = Work Factor (higher is more secure)
    }

    // Verify password during login
    public static boolean checkPassword(String enteredPassword, String storedHash) {
        return BCrypt.checkpw(enteredPassword, storedHash);
    }
}
