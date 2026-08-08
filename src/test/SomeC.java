package test;

import pt1.HomeworkN3.builder.Order;

public class SomeC {
    public static void main(String[] args) {
//        System.out.println(test("qwq"));;
//        System.out.println(test("tbank"));;
//        System.out.println(test("bacaba"));;
//        System.out.println(test("aaaaabacab"));;
//        System.out.println(test("bacabab"));;
        test(7, new int[] {3, 2, 4, 1, 4, 8, 3});
        canBePalindrome("dsadsa");


        Order order = Order.builder()
                .address("some address")
                .customerName("some name")
                .build();

    }



    public static int test(int n, int[] p) {
        int[] leftProfit = new int[n];
        int minPrice = p[0];
        for (int i = 1; i < n; i++) {
            minPrice = Math.min(minPrice, p[i]);
            leftProfit[i] = Math.max(leftProfit[i - 1], p[i] - minPrice);
        }

        int[] rightProfit = new int[n];
        int maxPrice = p[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxPrice = Math.max(maxPrice, p[i]);
            rightProfit[i] = Math.max(rightProfit[i + 1], maxPrice - p[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftProfit[i] + rightProfit[i]);
        }

        return ans;
    }

    public static String canBePalindrome(String s) {
        while (true) {
            if (isPalindrome(s)) {
                return "Yes";
            }

            boolean leftA = s.charAt(0) == 'a';
            boolean rightA = s.charAt(s.length() - 1) == 'a';

            if (!leftA && !rightA) {
                return "No";
            }

            if (leftA){
                s = s.substring(1);
            }
            else {
                s = s.substring(0, s.length() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
