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
        return Float.compare(amount, arg0.convert(timeUnit).amount);
    }
    public float getAmount(){
        return amount;
    }
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
		if(obj != null && obj instanceof TimePoint timePoint) {
			result = compareTo(timePoint) == 0;
		}
		return result;
    }
    public TimePoint convert(TimeUnit unit) {
        //returns new TimePoint with a given TimeUnit
        float newAmount = amount * timeUnit.getValueOfSeconds() / unit.getValueOfSeconds();
		return new TimePoint(newAmount, unit);
    }
    public TimePoint with(TimePointAdjuster adjuster) {
        return adjuster.adjust(this);
    }

}
