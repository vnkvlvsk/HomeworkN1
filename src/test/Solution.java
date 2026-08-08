package test;
import java.util.*;

public class Solution {
    static long[] a;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        long x = scanner.nextLong();
        a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();

        long ans = Long.MAX_VALUE;

        Set<Long> candidates = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long ai = a[i];
            long y = ((x + ai - 1) / ai) * ai;
            candidates.add(y);
            if (y - ai >= x) candidates.add(y - ai);
        }
        candidates.add(x);

        for (long y : candidates) {
            if (y >= x) {
                long total = coins(y) + coins(y - x);
                ans = Math.min(ans, total);
            }
        }

        System.out.println(ans);
    }

    static long coins(long sum) {
        long count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count += sum / a[i];
            sum %= a[i];
        }
        return count;
    }
}