package pers.adlered.fxxkinghackerpwd.core;

import pers.adlered.fxxkinghackerpwd.composite.Pair;
import pers.adlered.fxxkinghackerpwd.extend.RandomNum;

/**
 * Mess up && double salt
 */

public class Encrypt {
    public static Pair run(char[] str, char saltCode, char saltCode2) {
        char temp;
        char[] key = new char[str.length];
        for (int i = 0; i <= str.length - 1; i++) {
            int random;
            random = RandomNum.sumIntger(0, str.length-1, false);
            temp = str[random];
            str[random] = str[i];
            str[i] = temp;
            /*
            Add salt to ASCII(char)
             */
            //Prevent negative values
            if (saltCode < saltCode2) {
                char exchange;
                exchange = saltCode;
                saltCode = saltCode2;
                saltCode2 = exchange;
            }
            key[i] = (char)(random + (saltCode - saltCode2));
        }
        return new Pair(str, key);
    }
}
