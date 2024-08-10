package telran.time;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


class TimePointUnitTest {
    TimePoint p10Hours = new TimePoint(10, TimeUnit.HOUR);
    TimePoint p20Hours = new TimePoint(3600 * 20, TimeUnit.SECOND);
	@Test
	void testBetween() {
		
		float actual = TimeUnit.MINUTE.between(p10Hours, p20Hours);
		assertEquals(600, actual);
		actual = TimeUnit.SECOND.between(p10Hours, p20Hours);
		assertEquals(36000, actual);
		actual = TimeUnit.HOUR.between(p10Hours, p20Hours);
		assertEquals(10, actual);
	}
	@Test
	void convertTest() {
		TimePoint pointActual = p10Hours.convert(TimeUnit.SECOND);
        TimePoint pointExpected = new TimePoint(36000, TimeUnit.SECOND);
		assertEquals(pointExpected.getAmount(), pointActual.getAmount());
		assertEquals(pointExpected.getTimeUnit(), pointActual.getTimeUnit());
	}
	@Test
	void plusAdjusterTest() {
		TimePoint actual = p10Hours.with(new PlusTimePointAdjuster(3600 * 20, TimeUnit.SECOND));
		TimePoint expected = new TimePoint(30, TimeUnit.HOUR);

        assertEquals(expected.getAmount(), actual.getAmount());
		assertEquals(expected.getTimeUnit(), actual.getTimeUnit());
	}
	@Test
	void timePointEqualsTest() {
		TimePoint tp1 = new TimePoint(1, TimeUnit.HOUR);
		TimePoint tp2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint tp3 = new TimePoint(1, TimeUnit.MINUTE);
		
		assertEquals(tp1, tp2);
		assertNotEquals(tp1, tp3);
	}
	@Test
	void timePointCompareToTest() {
		TimePoint tp1 = new TimePoint(10, TimeUnit.HOUR);
		TimePoint tp2 = new TimePoint(60, TimeUnit.MINUTE);
		TimePoint tp3 = new TimePoint(100, TimeUnit.SECOND);
		TimePoint tp4 = new TimePoint(1, TimeUnit.HOUR);
		assertTrue(tp1.compareTo(tp2) > 0);
		assertTrue(tp3.compareTo(tp1) < 0);
		assertTrue(tp2.compareTo(tp4) == 0);
		
		
	}
	@Test
    void futureProximityAdjusterTest() {
            TimePoint tp1 = new TimePoint(60, TimeUnit.MINUTE);
            TimePoint tp2=  new TimePoint(90, TimeUnit.MINUTE);
            TimePoint tp3 = new TimePoint(2, TimeUnit.HOUR);
            TimePoint tp4 = new TimePoint(4, TimeUnit.HOUR);
            TimePoint tp5 = new TimePoint(120, TimeUnit.MINUTE);
            TimePoint [] timePoints = {
                    tp1, tp2, tp3, tp4, tp5
                    };
             TimePoint timePoint =  new TimePoint(90, TimeUnit.MINUTE);
             TimePointAdjuster adjuster = new FutureProximityAdjuster(timePoints);
             TimePoint actual = timePoint.with(adjuster);
              assertEquals(120, actual.getAmount());
              assertEquals(TimeUnit.MINUTE, actual.getTimeUnit());
              timePoint = new TimePoint(7200, TimeUnit.SECOND);
              actual = timePoint.with(adjuster);
              assertEquals(3600 * 4, actual.getAmount());
              assertEquals(TimeUnit.SECOND, actual.getTimeUnit());
              timePoint = new TimePoint(4, TimeUnit.HOUR);
              actual = timePoint.with(adjuster);
              assertNull(actual);
     }

}
