package String.P539MinimumTimeDifference;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @CLassName MinimumTimeDifference
 * @Description TODO
 * @Author cst
 * @Date 2/8/21  11:07 AM
 */
public class MinimumTimeDifference {
    public int findMinDifference(List<String> timePoints) {
        // like find the shortest distances between two elements in a circular array
        boolean[] points = new boolean[1440];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String time : timePoints) {
            String[] arrs = time.split(":");
            int h =  Integer.parseInt(arrs[0]);
            int m = Integer.parseInt(arrs[1]);
            int t = h * 60 + m;
            // it was visited before, so there must be two exactly same time. we could return 0 directly
            if (points[t]) {
                return 0;
            }
            points[t] = true;
            min = Math.min(min, t);
            max = Math.max(max, t);
        }

        int res = Integer.MAX_VALUE;
        int prev = 0;
        for (int i = min; i<= max; i++ ){
            if (points[i]) {
                if (i == min) {
                    // 比如23：59 和 0:00, 倒过来更接近
                    res = Math.min(res, Math.min(max - min, 1440 - (max - min)));
                } else {
                    res = Math.min(res, i - prev);
                }
                prev = i;
            }
        }
        return res;
    }
}
