package telran.time;

import java.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster{
    TimePoint [] timePoints;
    public FutureProximityAdjuster(TimePoint [] timePoints) {
       this.timePoints = Arrays.copyOf(timePoints, timePoints.length);
       Arrays.sort(this.timePoints);
    }
    @Override
    public TimePoint adjust(TimePoint timePoint) {
        
        TimePoint result = null;
        int index = getLeastOfGreaterIndex(timePoint);
        if (index < timePoints.length) {
            result = timePoints[index].convert(timePoint.getTimeUnit());
        }
       return result;
    }
    private int getLeastOfGreaterIndex(TimePoint timePoint) {
        int left = 0, right = timePoints.length - 1;
        int middle = (left + right) / 2;
        while(left <= right) {
            int compRes = timePoint.compareTo(timePoints[middle]);
            if (compRes < 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left;
    }
}
