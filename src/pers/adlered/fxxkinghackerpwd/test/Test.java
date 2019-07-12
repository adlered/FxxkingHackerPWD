package pers.adlered.fxxkinghackerpwd.test;

import pers.adlered.fxxkinghackerpwd.composite.PasswordPair;
import pers.adlered.fxxkinghackerpwd.sha1auth.AnalysisPWD;
import pers.adlered.fxxkinghackerpwd.sha1auth.CreatePWD;

public class Test {
    public static void main(String[] args) {
        String str = "qwe123你好世界HELLOWORLD!@#$%^&*()";
        PasswordPair passwordPair = CreatePWD.run(str, 'Z', 'z');
        System.out.println(passwordPair.getStr() + "\n" + passwordPair.getKey());

        PasswordPair recovery = new PasswordPair("qwe123你好世a界HELLOWORLD!@#$%^&*()", passwordPair.getKey());
        String sha1 = "";
        try {
            sha1 = AnalysisPWD.run(recovery, 'Z', 'z');
        } catch (ArrayIndexOutOfBoundsException AIOFBE) {
            System.out.println("Wrong key!");
        }
        System.out.println(sha1);
        if (passwordPair.getStr().equals(sha1)) {
            System.out.println("Password correct!");
        } else {
            System.out.println("Wrong password!");
        }
    }
}
