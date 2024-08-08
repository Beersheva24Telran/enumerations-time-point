package telran.time;

public enum TimeUnit {
SECOND(1), MINUTE(60), HOUR(3600);
private int valueOfSeconds;
TimeUnit(int valuOfSeconds) {
    this.valueOfSeconds = valuOfSeconds;
}
public int getValueOfSeconds(){
    return valueOfSeconds;
}
public float between(TimePoint p1, TimePoint p2) {
    //TODO 
    //return amount of "this" time units between p2 and p1
    //if p2 less than p1 a negative value should be returned
    return -1;
}
}
