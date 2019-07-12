package pers.adlered.fxxkinghackerpwd.core;

import pers.adlered.fxxkinghackerpwd.composite.Pair;

/**
 * Re-build can recovery mixed string with CORRECT-STR and CORRECT-KEY
 */

public class Rebuild {
    public static char[] run(Pair pair, char saltCode, char saltCode2) {
        char[] str = pair.getStr();
        char[] key = pair.getKey();
        char temp;
        for (int i = 0; i <= str.length - 1; i++) {
            char set;
            set = key[i];
            if (saltCode < saltCode2) {
                char exchange;
                exchange = saltCode;
                saltCode = saltCode2;
                saltCode2 = exchange;
            }
            int real = set - (saltCode - saltCode2);
            temp = str[real];
            str[real] = str[i];
            str[i] = temp;
        }
        return str;
    }
}
