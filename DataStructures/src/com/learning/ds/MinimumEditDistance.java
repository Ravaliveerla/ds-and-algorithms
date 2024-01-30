package com.learning.ds;

/**
 * .gandla
 * <p>
 * Given two strings how many minimum edits(update, delete or add) is
 * needed to convert one string to another
 * <p>
 * Time complexity is O(m*n) Space complexity is O(m*n)
 * <p>
 * References:
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Edit_distance
 * https://allaboutalgorithms.wordpress.com/2011/10/31/edit-distance-between-two-strings-using-recursion/
 * https://stackoverflow.com/questions/14616339/complexity-of-edit-distance-levenshtein-distance-recursion-top-down-implementa
 */
public class MinimumEditDistance {

    /**
     * Uses recursion to find minimum edits
     */
    public int recEditDistance(char[] str1, char str2[], int x, int y) {

        if (str2.length == y) return (str1.length - x);
        if (str1.length == x) return (str2.length - y);

        if (str1[x] == str2[y]) return recEditDistance(str1, str2, x + 1, y + 1);

        return 1 + Math.min(Math.min(recEditDistance(str1, str2, x, y + 1), recEditDistance(str1, str2, x + 1, y)), recEditDistance(str1, str2, x + 1, y + 1));
    }

    /**
     * Uses bottom up DP to find the edit distance
     */
    public int dynamicEditDistance(char[] str1, char[] str2) {
        int temp[][] = new int[str1.length + 1][str2.length + 1];

        for (int i = 0; i < temp[0].length; i++) {
            temp[0][i] = i;
        }

        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = i;
        }

        for (int i = 1; i <= str1.length; i++) {
            for (int j = 1; j <= str2.length; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1];
                } else {
                    temp[i][j] = 1 + min(temp[i - 1][j - 1], temp[i - 1][j],
                            temp[i][j - 1]);
                }
            }
        }
        //printActualEdits(temp, str1, str2);
        return temp[str1.length][str2.length];

    }

    /**
     * Prints the actual edits which needs to be done.
     */
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while (true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i - 1] == str2[j - 1]) {
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j - 1] + 1) {
                System.out.println("Edit " + str2[j - 1] + " in string2 to "
                        + str1[i - 1] + " in string1");
                i = i - 1;
                j = j - 1;
            } else if (T[i][j] == T[i - 1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i - 1]);
                i = i - 1;
            } else if (T[i][j] == T[i][j - 1] + 1) {
                System.out.println("Delete in string2 " + str2[j - 1]);
                j = j - 1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    private int min(int a, int b, int c) {
        int l = Math.min(a, b);
        return Math.min(l, c);
    }

    public static void main(String args[]) {
        invoke("Hello", "Helo"); // 1
        invoke("Hello", "Hell"); // 1
        invoke("Hello", "Bello"); // 1
        invoke("Hello", "Bell"); // 2
        invoke("Hello", ""); // 5
        invoke("", "Hello"); // 5
        invoke("Hammerr", "Hello"); // 6
        invoke("Hammerr", "Helo"); // 5
    }

    private static void invoke(String str1, String str2) {
        MinimumEditDistance editDistance = new MinimumEditDistance();
        int result1 = editDistance.recEditDistance(str1.toCharArray(),
                str2.toCharArray(), 0, 0);
        int result2 = editDistance.dynamicEditDistance(str1.toCharArray(),
                str2.toCharArray());
        System.out.println("[" + str1 + ", " + str2 + "] :: " + "Recurrsion: " + result1 + ", DP: " + result2);
    }

}