import java.util.Arrays;

public class RussianDollEnvelope {
    class Envelope implements Comparable<Envelope> {
        int h, w;

        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }

        public int compareTo(Envelope e) {
            if (this.h != e.h)
                return this.h - e.h;
            return this.w - e.w;
        }
    }

    public int maxEnvelopes(int[][] nums) {
        int n = nums.length;
        Envelope[] envelope = new Envelope[n];
        for (int i = 0; i < n; i++) {
            envelope[i] = new Envelope(nums[i][0], nums[i][1]);
        }

        Arrays.sort(envelope);
        int res = 0;
        int dp[] = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (envelope[i].h > envelope[j].h && envelope[i].w > envelope[j].w) {
                    if (dp[j] > max)
                        max = dp[j];
                }
            }
            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
