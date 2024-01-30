package com.learning.ds;

public class SparseSearch {

    public static void main(String[] args) {
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "zebra"}, "zebra")); // 12
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball")); // 4
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "zebra")); // -1
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "zebra"}, "at")); // 0
        System.out.println(sparseSearch(new String[]{"at", "", "", "", "", "", ""}, "at")); // 0
        System.out.println(sparseSearch(new String[]{"", "", "", "", "", "", "zebra"}, "zebra")); // 6
        System.out.println(sparseSearch(new String[]{"", "", "hello", "", ""}, "hello")); // 2
        System.out.println(sparseSearch(new String[]{"", "", "", "", ""}, "hello")); // -1
        System.out.println(sparseSearch(new String[]{"apple", "ball", "cat", "doll", "zebra"}, "apple")); // 0
        System.out.println(sparseSearch(new String[]{"apple", "ball", "cat", "doll", "zebra"}, "cat")); // 2
        System.out.println(sparseSearch(new String[]{"apple", "ball", "cat", "doll", "zebra"}, "zebra")); // 4
        System.out.println(sparseSearch(new String[]{"apple", "ball", "cat", "doll", "zebra"}, "dust")); // -1
    }

    public static int sparseSearch(String[] strings, String str) {
        return sparseSearch(strings, str, 0, strings.length - 1);
    }

    private static int sparseSearch(String[] strings, String str, int first, int last) {

        if (first > last) {
            return -1;
        }

        int mid = first + (last - first) / 2;
        int left = mid - 1;
        int right = mid + 1;

        if (strings[mid].isEmpty()) {
            while (left >= first && right <= last) {
                if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                } else if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }

                right++;
                left--;
            }
        }

        if (left + 1 < first || right - 1 > last) {
            return -1;
        }

        if (str.equals(strings[mid])) {
            return mid;
        } else if (strings[mid].compareTo(str) < 0) {
            return sparseSearch(strings, str, mid + 1, last);
        } else {
            return sparseSearch(strings, str, first, mid - 1);
        }
    }
}
