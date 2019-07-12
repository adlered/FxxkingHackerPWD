package pers.adlered.fxxkinghackerpwd.extend;

import java.util.Random;

public class RandomNum {
    public static int sumIntger(int min, int max, boolean needNegative) {
        int result;
        Random random = new Random();
        int sumNum = random.nextInt(max - min + 1) + min;
        if (needNegative == true) {
            int temp = random.nextInt(10) + 1;
            Int2String i2s = new Int2String(0);
            i2s.setInt(sumNum);
            String randomArg = i2s.returnString();
            switch (temp) {
                case 1:
                    if ((randomArg.contains("0")) || (randomArg.contains("9"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 2:
                    if ((randomArg.contains("1")) || (randomArg.contains("8"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 3:
                    if ((randomArg.contains("2")) || (randomArg.contains("7"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 4:
                    if ((randomArg.contains("3")) || (randomArg.contains("6"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 5:
                    if ((randomArg.contains("4")) || (randomArg.contains("5"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
            }
            sumNum = Integer.parseInt(randomArg);
            result = sumNum;
            return result;
        }
        return sumNum;
    }

    public static double sumDecimal(double min, double max, boolean needNegative) {
        double result = 0;
        int minInt = (int) min;
        String temp = min + "";
        String temp2 = temp.substring(temp.indexOf("."));
        String temp3 = temp2.replace(".", ""); //提取出小数位
        int maxInt = (int) max;
        String decTemp = max + "";
        String decTemp2 = decTemp.substring(temp.indexOf("."));
        String decTemp3 = decTemp2.replace(".", "");
        int minDecimalResult;
        int maxDecimalResult;
        minDecimalResult = Integer.valueOf(temp3).intValue();
        maxDecimalResult = Integer.valueOf(decTemp3).intValue();
        boolean isOk = false;
        do {
            int getInt = sumIntger(minInt, maxInt, false);
            int getDec = 0;
            if (minInt == maxInt) {
                if (minDecimalResult < maxDecimalResult)
                    getDec = sumIntger(minDecimalResult, maxDecimalResult, false);
                if (minDecimalResult > maxDecimalResult)
                    getDec = sumIntger(maxDecimalResult, minDecimalResult, false);
            } else { //瞎猫碰上死耗子
                if (minDecimalResult < maxDecimalResult)
                    getDec = sumIntger(0, maxDecimalResult, false);
                if (minDecimalResult > maxDecimalResult)
                    getDec = sumIntger(0, minDecimalResult, false);
            }
            String spell = getInt + "." + getDec;
            double getSpell = Double.valueOf(spell);
            if (minInt != maxInt) {
                if (getInt == minInt && getDec >= minDecimalResult) {
                    isOk = true;
                } else if (getInt == maxInt && getDec <= maxDecimalResult) {
                    isOk = true;
                } else if (getInt != minInt && getInt != maxInt) {
                    isOk = true;
                }
            } else {
                if (getDec >= minDecimalResult && getDec <= maxDecimalResult) {
                    isOk = true;
                }
            }
            if (isOk == false) {
            } else {
                result = getSpell;
            }
        } while (isOk == false);
        if (needNegative == true) {
            Random random = new Random();
            int tempR = random.nextInt(10) + 1;
            Double2String d2s = new Double2String(result);
            String randomArg = d2s.returnString();
            switch (tempR) {
                case 1:
                    if ((randomArg.contains("0")) || (randomArg.contains("9"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 2:
                    if ((randomArg.contains("1")) || (randomArg.contains("8"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 3:
                    if ((randomArg.contains("2")) || (randomArg.contains("7"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 4:
                    if ((randomArg.contains("3")) || (randomArg.contains("6"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
                case 5:
                    if ((randomArg.contains("4")) || (randomArg.contains("5"))) {
                        randomArg = "-" + randomArg;
                        break;
                    }
            }
            double getRes = Double.valueOf(randomArg);
            result = getRes;
        }
        return result;
    }

    static class Int2String {
        String ArgNum = "";

        public Int2String(int RecivedNum) {
            ArgNum = RecivedNum + "";
        }

        String returnString() {
            return ArgNum;
        }

        void setInt(int RecivedNum) {
            ArgNum = RecivedNum + "";
        }
    }

    static class Double2String {
        String ArgNum = "";

        public Double2String(double RecivedNum) {
            ArgNum = RecivedNum + "";
        }

        String returnString() {
            return ArgNum;
        }

        void setDouble(double RecivedNum) {
            ArgNum = RecivedNum + "";
        }
    }
}
