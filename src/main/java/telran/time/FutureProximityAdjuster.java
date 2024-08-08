package telran.time;

public class FutureProximityAdjuster implements TimePointAdjuster{
    TimePoint [] timePoints;
    public FutureProximityAdjuster(TimePoint [] timePoints) {
        //TODO
        //copy a given array
        //sort copy and assign to the field timePoints
        //using Java standard Arrays class
        //repeated time points are possible
    }
    @Override
    public TimePoint adjust(TimePoint timePoint) {
        // TODO Auto-generated method stub
       //returns a time point only in future (greater than a given time point) from the field timePoints
       //nearest to a given timePoint 
       return null;
    }
}
