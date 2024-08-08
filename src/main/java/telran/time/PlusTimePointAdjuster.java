package telran.time;

public class PlusTimePointAdjuster implements TimePointAdjuster{
    private int amount;
    private TimeUnit timeUnit;
    public PlusTimePointAdjuster(int amount, TimeUnit timeUnit) {
        this.amount = amount;
        this.timeUnit = timeUnit;
    }
    @Override
    public TimePoint adjust(TimePoint timePoint) {
        TimePoint point = timePoint.convert(timeUnit);
        float amountPoint = point.getAmount() + amount;
        TimePoint pointTemp = new TimePoint(amountPoint, timeUnit);
        return pointTemp.convert(timePoint.getTimeUnit());
    }
    

}
