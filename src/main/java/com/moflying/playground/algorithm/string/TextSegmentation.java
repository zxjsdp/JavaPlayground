package com.moflying.playground.algorithm.string;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.moflying.playground.utils.CollectionUtil;

import java.util.ArrayList;
import java.util.List;

public class TextSegmentation {
    private static final Double BASE_SCORE = 0.5;

    private static void example() {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String[] sentences = new String[] {"兰州正宗牛肉拉面", "兰州拉面"};
        for (String sentence : sentences) {
            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX));
        }
    }

    private static void processSegmentation(String str1, String str2) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> segTokenList1 = segmenter.process(str1, JiebaSegmenter.SegMode.INDEX);
        List<SegToken> segTokenList2 = segmenter.process(str2, JiebaSegmenter.SegMode.INDEX);

        System.out.println("---------------------------------");
        System.out.println(segTokenList1);
        System.out.println(segTokenList2);
        System.out.println("---------------------------------");
    }

    public static Double computeSegmentationSimilarity(String s1, String s2) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<SegToken> segList1 = segmenter.process(s1, JiebaSegmenter.SegMode.INDEX);
        List<SegToken> segList2 = segmenter.process(s2, JiebaSegmenter.SegMode.INDEX);

        List<String> wordIntersectionList = new ArrayList<>();

        for (SegToken st1 : segList1) {
            for (SegToken st2 : segList2) {
                if (st2.word.equals(st1.word)) {
                    wordIntersectionList.add(st1.word);
                }
            }
        }

        if (CollectionUtil.isBlank(wordIntersectionList)) {
            return 0.0;
        }

        return BASE_SCORE + 0.5 * (wordIntersectionList.size() * 1.0 / Math.max(segList1.size(), segList2.size()));
    }

    public static void main(String[] args) {
//        processSegmentation("兰州正宗牛肉拉面", "兰州拉面");
//        processSegmentation("哆哆呀简餐", "哆哆呀简餐美味");
//        processSegmentation("成都汤王牛肉粉店", "汤王牛肉米粉");
//        processSegmentation("Uncle`s Pizza", "UNCLE'S PIZZA");
//        processSegmentation("老鸭粉丝", "汤王牛肉米粉");
//        processSegmentation("哆哆呀简餐", "汤王牛肉米粉");

        System.out.println(computeSegmentationSimilarity("兰州正宗牛肉拉面", "兰州拉面"));
        System.out.println(computeSegmentationSimilarity("哆哆呀简餐", "哆哆呀简餐美味"));
        System.out.println(computeSegmentationSimilarity("成都汤王牛肉粉店", "汤王牛肉米粉"));
        System.out.println(computeSegmentationSimilarity("Uncle`s Pizza", "UNCLE'S PIZZA"));
        System.out.println(computeSegmentationSimilarity("老鸭粉丝", "汤王牛肉米粉"));
        System.out.println(computeSegmentationSimilarity("哆哆呀简餐", "汤王牛肉米粉"));
    }
}
