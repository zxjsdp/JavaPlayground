package com.moflying.playground.algorithm.string;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CosineComputerII {
    public double computeSimilarity(String source, String target) throws Exception {
        if (StringUtils.isBlank(source) || StringUtils.isBlank(target)) {
            throw new ValueException("source or target is blank: " + source + "," + target);
        }

        Map<Object, int[]> calcMap = new HashMap<Object, int[]>();
        calcSource(calcMap, source);
        calcTarget(calcMap, target);

        Iterator<Object> it = calcMap.keySet().iterator();
        double sqsource = 0;
        double sqtarget = 0;
        double denominator = 0;
        while (it.hasNext()) {
            int[] c = calcMap.get(it.next());
            denominator += c[0] * c[1];
            sqsource += c[0] * c[0];
            sqtarget += c[1] * c[1];
        }

        return denominator / Math.sqrt(sqsource * sqtarget);
    }

    private void calcSource(Map<Object, int[]> calcMap, String item) {
        for (int i = 0; i < item.length(); i++) {
            char ch = item.charAt(i);
            if (isChinese(ch)) {
                addBySource(calcMap, ch);
            } else if (isEnLetter(ch)) {
                StringBuilder sb = new StringBuilder(ch);
                for (; i < item.length() - 1; i++) {
                    char let_ch = item.charAt(i + 1);
                    if (!isEnLetter(let_ch)) {
                        break;
                    }
                    sb.append(let_ch);
                }
                addBySource(calcMap, sb.toString().toLowerCase());
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder(ch);
                for (; i < item.length() - 1; i++) {
                    char dig_ch = item.charAt(i + 1);
                    if (!Character.isDigit(dig_ch)) {
                        break;
                    }
                    sb.append(dig_ch);
                }
                addBySource(calcMap, sb.toString());
            }
        }
    }

    private void calcTarget(Map<Object, int[]> calcMap, String item) {
        for (int i = 0; i < item.length(); i++) {
            char ch = item.charAt(i);
            if (isChinese(ch)) {
                addByTarget(calcMap, ch);
            } else if (isEnLetter(ch)) {
                StringBuilder sb = new StringBuilder(ch);
                for (; i < item.length() - 1; i++) {
                    char let_ch = item.charAt(i + 1);
                    if (!isEnLetter(let_ch)) {
                        break;
                    }
                    sb.append(let_ch);
                }
                addByTarget(calcMap, sb.toString().toLowerCase());
            } else if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder(ch);
                for (; i < item.length() - 1; i++) {
                    char dig_ch = item.charAt(i + 1);
                    if (!Character.isDigit(dig_ch)) {
                        break;
                    }
                    sb.append(dig_ch);
                }
                addByTarget(calcMap, sb.toString());
            }
        }
    }

    private void addBySource(Map<Object, int[]> calcMap, Object obj) {
        int[] fq = calcMap.get(obj);
        if (fq != null) {
            fq[0]++;
        } else {
            fq = new int[2];
            fq[0] = 1;
            fq[1] = 0;
            calcMap.put(obj, fq);
        }
    }

    private void addByTarget(Map<Object, int[]> calcMap, Object obj) {
        int[] fq = calcMap.get(obj);
        if (fq != null) {
            fq[1]++;
        } else {
            fq = new int[2];
            fq[0] = 0;
            fq[1] = 1;
            calcMap.put(obj, fq);
        }
    }

    /**
     * 判断是否汉字
     * @param ch
     * @return
     */
    public static boolean isChinese(char ch) {
        return ch >= 0x4E00 && ch <= 0x9FA5;
    }

    /**
     * 判断是否英文
     * @param ch
     * @return
     */
    public static boolean isEnLetter(char ch) {
        return (ch >= 0x61 && ch <= 0x7a)
                || (ch >= 0x41 && ch <= 0x5a);
    }

    /**
     * 是否是英文
     * @param str
     * @return
     */
    public static boolean isEnLetter(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i + 1);
            if (!isEnLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从字符串中过滤出数字
     * @param str
     * @return
     */
    public static String getNumberByString(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String getLastNumInString(String content) {
        if (content == null) {
            return null;
        }
        int index = content.length() - 1;
        int stopIndex = -1;
        int startIndex = -1;
        while (index >= 0) {
            if (Character.isDigit(content.charAt(index))) {
                if (stopIndex == -1) {
                    stopIndex = index;
                }
                startIndex = index;
                --index;
            } else if (startIndex != -1 && stopIndex != -1) {
                break;
            }else {
                --index;
            }
        }
        if (startIndex != -1 && stopIndex != -1) {
            return content.substring(startIndex, stopIndex + 1);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        CosineComputerII cosineComputerII = new CosineComputerII();
//        double result = consineComputerII.computeSimilarity("味佳乐蛋糕（海河路）", "WEIJIALE味佳乐");
//		System.out.println(result);
        System.out.println(cosineComputerII.computeSimilarity("兰州正宗牛肉拉面", "兰州拉面"));
        System.out.println(cosineComputerII.computeSimilarity("Sunny", "Sunday"));
        System.out.println(cosineComputerII.computeSimilarity("Sunny店", "Sunday店"));
        System.out.println(cosineComputerII.computeSimilarity("Sunday店", "Sunday店"));
        System.out.println(cosineComputerII.computeSimilarity("华阴路5号", "上海市普陀区华阴路5号"));
    }
}
