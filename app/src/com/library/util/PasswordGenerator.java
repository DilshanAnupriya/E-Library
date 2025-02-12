package com.library.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordGenerator {
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean check(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
