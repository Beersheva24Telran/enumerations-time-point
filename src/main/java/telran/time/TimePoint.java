package telran.time;

public class TimePoint implements Comparable<TimePoint>{
    private float amount;
    private TimeUnit timeUnit;
    public TimePoint(float amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public int compareTo(TimePoint arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
    public float getAmount(){
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {
        //TODO
        return false;
    }
    public TimePoint convert(TimeUnit timeUnit) {
        //TODO
        //returns new TimePoint object equaled to the "this" object but
        //with a gibven timeUnit
        return null;
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}
