package com.learning.ds;

public class ScoreCombinations {

    public static void main(String[] args) {
        System.out.println(new ScoreCombinations().combinationScore(new int[]{2, 3, 7}, 12));
        System.out.println(new ScoreCombinations().combinationScore(new int[]{3, 5, 10}, 20));
    }

    private static class Result {
        private int value;
    }

    public int combinationScore(int[] scores, int target) {
        if (scores == null || scores.length == 0) return 0;

        Result result = new Result();
        dfs(scores, target, 0, result);

        return result.value;
    }

    private void dfs( int[] scores, int target, int index, Result result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.value++;
            return;
        }

        for (int i = index; i < scores.length; i++) {
            dfs(scores, target - scores[i], i, result);
        }
    }
}
