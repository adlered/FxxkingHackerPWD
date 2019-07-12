package pers.adlered.fxxkinghackerpwd.composite;

/**
 * Storage "Encrypted String" && "Key"
 */

public class Pair {
    private char[] str;
    private char[] key;

    public Pair(char[] str, char[] key) {
        this.str = str;
        this.key = key;
    }

    public char[] getStr() {
        return str;
    }

    public char[] getKey() {
        return key;
    }
}
