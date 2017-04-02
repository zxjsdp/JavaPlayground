package com.moflying.playground.algorithm.string;

import info.debatty.java.stringsimilarity.*;

import static com.moflying.playground.algorithm.string.StringDistance.*;

/**
 * Similarity
 */
public class StringSimilarity {
    public static double checkLevenshteinSimilarity(String s1, String s2) {
        Double distance = checkLevenshteinDistance(s1, s2);
        return 1 - distance / Math.max(s1.length(), s2.length());
    }

    public static double checkNormalizedLevenshteinSimilarity(String s1, String s2) {
        NormalizedLevenshtein l = new NormalizedLevenshtein();
        return l.similarity(s1, s2);
    }

    public static double checkWeightedLevenshteinSimilarity(String s1, String s2) {
        Double distance = checkWeightedLevenshteinDistance(s1, s2);
        return 1 - distance / Math.max(s1.length(), s2.length());
    }

    public static double checkDamerauLevenshteinSimilarity(String s1, String s2) {
        Double distance = checkDamerauLevenshteinDistance(s1, s2);
        return 1 - distance / Math.max(s1.length(), s2.length());
    }

    public static double checkOptimalStringAlignmentSimilarity(String s1, String s2) {
        return 0;
    }

    public static double checkJaroWinklerSimilarity(String s1, String s2) {
        JaroWinkler jw = new JaroWinkler();

        // substitution of s and t
        return jw.similarity(s1, s2);
    }

    public static double checkLCSSimilarity(String s1, String s2) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();

        long lcsLength = lcs.length(s1, s2);

        return 2 * lcsLength * 1.0 / (s1.length() + s2.length());
    }

    public static double checkMetricLCSSimilarity(String s1, String s2) {
        info.debatty.java.stringsimilarity.MetricLCS lcs =
                new info.debatty.java.stringsimilarity.MetricLCS();

        return 1 - lcs.distance(s1, s2);
    }

    public static double checkNGramSimilarity(String s1, String s2) {
        return 0;
    }

    public static double checkQGramSimilarity(String s1, String s2) {
        return 0;
    }

    public static double checkCosineSimilarityA(String s1, String s2) {
        Cosine cosine = new Cosine();
        return cosine.similarity(s1, s2);
    }

    public static double checkJaccardSimilarity(String s1, String s2) {
        Jaccard jaccard = new Jaccard();
        return jaccard.similarity(s1, s2);
    }

    public static double checkSorensenDiceCoefficientSimilarity(String s1, String s2) {
        SorensenDice sorensenDice = new SorensenDice();
        return sorensenDice.similarity(s1, s2);
    }

    public static void main(String[] args) {
    }
}
