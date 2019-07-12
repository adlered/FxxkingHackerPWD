package pers.adlered.fxxkinghackerpwd.core;

import pers.adlered.fxxkinghackerpwd.composite.Pair;

/**
 * Decrypt
 */

public class Decrypt {
    public static char[] run(Pair pair, char saltCode, char saltCode2) {
        char[] str = pair.getStr();
        char[] key = pair.getKey();
        for (int i = key.length - 1; i >= 0; i--) {
            char temp;
            char set;
            temp = str[i];
            set = key[i];
            if (saltCode < saltCode2) {
                char exchange;
                exchange = saltCode;
                saltCode = saltCode2;
                saltCode2 = exchange;
            }
            int real = set - (saltCode - saltCode2);
            str[i] = str[real];
            str[real] = temp;
        }
        return str;
    }
}
