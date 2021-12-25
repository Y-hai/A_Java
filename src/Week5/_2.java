package Week5;

public class _2 {
    public static void main(String[] args) {
        long ans = 0l;
        for (int i = 1; i <= 2021; i++) {
            if (check(i)) {
                ans += i * i;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int n) {
        while (n != 0) {
            if (n % 10 == 1 || n % 10 == 2 || n % 10 == 7 || n % 10 == 9) {
                return true;
            }
            n /= 10;
        }
        return false;
    }
}
