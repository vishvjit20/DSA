
import java.util.*;

public class MergeIntervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();
        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            if (intervals.get(i).end < newInterval.start) {
                res.add(intervals.get(i));
            } else if (intervals.get(i).start > newInterval.end) {
                res.add(newInterval);
                while (i < n)
                    res.add(intervals.get(i++));
                return res;
            } else {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}
