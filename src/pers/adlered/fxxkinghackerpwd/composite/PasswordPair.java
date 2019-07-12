package pers.adlered.fxxkinghackerpwd.composite;

/**
 * Pair of STR && KEY, for user in String.
 */

public class PasswordPair {
    private String str;
    private String key;

    public PasswordPair(String str, String key) {
        this.str = str;
        this.key = key;
    }

    public String getStr() {
        return str;
    }

    public String getKey() {
        return key;
    }
}
