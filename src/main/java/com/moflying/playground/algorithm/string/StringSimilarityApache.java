package com.moflying.playground.algorithm.string;

import org.apache.commons.text.beta.similarity.CosineDistance;
import org.apache.commons.text.beta.similarity.JaroWinklerDistance;

public class StringSimilarityApache {
    private static Double computeCosineDistance(String s1, String s2) {
        CosineDistance cosineDistance = new CosineDistance();
        return cosineDistance.apply(s1, s2);
    }

    private static Double computeJaroWinklerDistance(String s1, String s2) {
        JaroWinklerDistance jaroWinklerDistance = new JaroWinklerDistance();
        return jaroWinklerDistance.apply(s1, s2);
    }

    public static void main(String[] args) {
    }
}
