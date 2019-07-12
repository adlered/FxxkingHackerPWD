package pers.adlered.fxxkinghackerpwd.sha1auth;

import org.apache.commons.codec.digest.DigestUtils;
import pers.adlered.fxxkinghackerpwd.composite.Pair;
import pers.adlered.fxxkinghackerpwd.composite.PasswordPair;
import pers.adlered.fxxkinghackerpwd.core.Encrypt;

/**
 * Sum a Pair include "sha1Hexed STR" and KEY.
 */

public class CreatePWD {
    public static PasswordPair run(String password, char saltCode, char saltCode2) {
        Pair pair = Encrypt.run(password.toCharArray(), saltCode, saltCode2);
        return new PasswordPair(
                DigestUtils.sha1Hex(String.valueOf(pair.getStr())),
                String.valueOf(pair.getKey())
        );
    }
}
