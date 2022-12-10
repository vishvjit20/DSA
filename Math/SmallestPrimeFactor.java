package Math;

public class SmallestPrimeFactor {
    public static void main(String args[]) {
        int n = 20;
        int spf[] = new int[n + 1];
        for (int i = 0; i < n; i++)
            spf[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    spf[j] = i;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(i + " " + spf[i]);
        }
    }
}
