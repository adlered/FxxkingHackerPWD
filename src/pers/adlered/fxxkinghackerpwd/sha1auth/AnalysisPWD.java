package pers.adlered.fxxkinghackerpwd.sha1auth;

import org.apache.commons.codec.digest.DigestUtils;
import pers.adlered.fxxkinghackerpwd.composite.Pair;
import pers.adlered.fxxkinghackerpwd.composite.PasswordPair;
import pers.adlered.fxxkinghackerpwd.core.Rebuild;

/**
 * Calculate sha1 result with USER-INPUT-STR and STORAGED-KEY.
 */

public class AnalysisPWD {
    public static String run(String checkingPassword, String key, char saltCode, char saltCode2) {
        Pair pair = new Pair(checkingPassword.toCharArray(), key.toCharArray());
        String mixed = String.valueOf(Rebuild.run(pair, saltCode, saltCode2));
        String sha1 = DigestUtils.sha1Hex(mixed);
        return sha1;
    }

    public static String run(PasswordPair passwordPair, char saltCode, char saltCode2) {
        Pair pair = new Pair(passwordPair.getStr().toCharArray(), passwordPair.getKey().toCharArray());
        String mixed = String.valueOf(Rebuild.run(pair, saltCode, saltCode2));
        String sha1 = DigestUtils.sha1Hex(mixed);
        return sha1;
    }
}
