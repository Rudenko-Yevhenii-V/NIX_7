package ry.rudenko.yevhenii.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class SecurityUtil {

    private SecurityUtil() { }

    public static String hashPassword(String password) {
        return DigestUtils.sha256Hex(password);
    }
}
