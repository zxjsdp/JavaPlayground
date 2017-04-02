package com.moflying.playground.algorithm.string;

import com.moflying.playground.algorithm.string.algorithmUtil.StringCleaner;
import com.moflying.playground.algorithm.string.entity.StringComparison;
import com.moflying.playground.utils.CollectionUtil;
import info.debatty.java.stringsimilarity.*;

import java.util.Arrays;
import java.util.List;

public class StringDistance {
    private static final String STR_A = "谷田稻香（真北路）";
    private static final String STR_B = "谷田稻香（徐汇区）";

    public static double checkLevenshteinDistance(String str1, String str2) {
        Levenshtein l = new Levenshtein();

        return l.distance(str1, str2);
    }

    public static double checkNormalizedLevenshteinDistance(String str1, String str2) {
        NormalizedLevenshtein l = new NormalizedLevenshtein();

        return l.distance(str1, str2);
    }


    public static double checkWeightedLevenshteinDistance(String str1, String str2) {
        WeightedLevenshtein wl = new WeightedLevenshtein(
                new CharacterSubstitutionInterface() {
                    public double cost(char c1, char c2) {

                        // The cost for substituting 't' and 'r' is considered
                        // smaller as these 2 are located next to each other
                        // on a keyboard
                        if (c1 == 't' && c2 == 'r') {
                            return 0.5;
                        }

                        // For most cases, the cost of substituting 2 characters
                        // is 1.0
                        return 1.0;
                    }
                });

        return wl.distance(str1, str2);
    }

    public static double checkDamerauLevenshteinDistance(String str1, String str2) {
        Damerau d = new Damerau();

        return d.distance(str1, str2);
    }

    public static double checkOptimalStringAlignmentDistance(String str1, String str2) {
        OptimalStringAlignment osa = new OptimalStringAlignment();

        return osa.distance(str1, str2);
    }

    public static double checkJaroWinklerDistance(String str1, String str2) {
        JaroWinkler jw = new JaroWinkler();

        // substitution of s and t
        return jw.distance(str1, str2);
    }


    public static double checkLongestCommonSubsequence(String str1, String str2) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        // Will produce 4.0
        return lcs.distance(str1, str2);
    }

    public static double checkMetricLCS(String str1, String str2) {
        info.debatty.java.stringsimilarity.MetricLCS lcs =
                new info.debatty.java.stringsimilarity.MetricLCS();

        return lcs.distance(str1, str2);
    }

    public static double checkNGram(String str1, String str2) {
        // produces 0.416666
        NGram twogram = new NGram(2);
        return twogram.distance(str1, str2);
    }

    public static double checkQGram(String str1, String str2) {
        QGram qGram = new QGram();
        return qGram.distance(str1, str2);
    }

    public static double checkCosineDistance(String str1, String str2) {
        Cosine cosine = new Cosine();
        return cosine.distance(str1, str2);
    }

    public static double checkJaccard(String str1, String str2) {
        Jaccard jaccard = new Jaccard();
        return jaccard.distance(str1, str2);
    }

    public static double checkSorensenDiceCoefficient(String str1, String str2) {
        SorensenDice sorensenDice = new SorensenDice();
        return sorensenDice.distance(str1, str2);
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static void checkAlgorithms(String a, String b) {
        a = StringCleaner.removeContentsInParentheses(a);
        b = StringCleaner.removeContentsInParentheses(b);

        a = StringCleaner.toLowerCase(a);
        b = StringCleaner.toLowerCase(b);

        System.out.println("--------------------------------------------------");
        System.out.println(a);
        System.out.println(b);

        System.out.printf("Levenshtein:                          %s\n", checkLevenshteinDistance(a, b));
        System.out.printf("NormalizedLevenshtein:   (Normalized) %s\n", checkNormalizedLevenshteinDistance(a, b));
        System.out.printf("WeightedLevenshtein:                  %s\n", checkWeightedLevenshteinDistance(a, b));
        System.out.printf("DamerauLevenshtein:                   %s\n", checkDamerauLevenshteinDistance(a, b));
        System.out.printf("OptimalStringAlignment:               %s\n", checkOptimalStringAlignmentDistance(a, b));
        System.out.printf("JaroWinkler:             (Normalized) %s\n", checkJaroWinklerDistance(a, b));
        System.out.printf("LongestCommonSubsequence:             %s\n", checkLongestCommonSubsequence(a, b));
        System.out.printf("MetricLCS:               (Normalized) %s\n", checkMetricLCS(a, b));
        System.out.printf("NGram:                   (Normalized) %s\n", checkNGram(a, b));
        System.out.printf("QGram:                                %s\n", checkQGram(a, b));
        System.out.printf("Cosine:                  (Normalized) %s\n", checkCosineDistance(a, b));
        System.out.printf("Jaccard:                 (Normalized) %s\n", checkJaccard(a, b));
        System.out.printf("SorensenDiceCoefficient: (Normalized) %s\n", checkSorensenDiceCoefficient(a, b));
    }

    private static void checkMultipleAlgorithms(List<StringComparison> stringComparisonList) {
        if (CollectionUtil.isBlank(stringComparisonList)) {
            return;
        }

        stringComparisonList.forEach(stringComparison ->
            checkAlgorithms(stringComparison.getStr1(), stringComparison.getStr2())
        );
    }

    public static void main(String[] args) {
        List<StringComparison> stringComparisonList = Arrays.asList(
//                new StringComparison(STR_A, STR_B),
                new StringComparison("兰州正宗牛肉拉面（轻纺路店）", "兰州拉面"),
                new StringComparison("兰州正宗拉面", "兰州拉面"),
                new StringComparison("哆哆呀简餐", "哆哆呀简餐美味"),
                new StringComparison("成都汤王牛肉粉店（武汉路店）", "汤王牛肉米粉"),
                new StringComparison("Uncle`s Pizza", "UNCLE'S PIZZA"),
                new StringComparison("老鸭粉丝", "汤王牛肉米粉"),
                new StringComparison("哆哆呀简餐", "汤王牛肉米粉"),
                new StringComparison("CONAIR", "AIRCON")
        );

        checkMultipleAlgorithms(stringComparisonList);
    }
}
