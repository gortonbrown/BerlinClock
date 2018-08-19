import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Clock.BerlinClock;
import org.junit.Assert;

public class ClockTest {
	
	private BerlinClock clock;
	
	@Before
	public void init() {
		clock = new BerlinClock();
	}
	
	@Test
	public void testTheHourof10isTwoBlocks() {
		Integer lowerExpected = 0;
		Integer upperExpected = 2;
		
		clock.getHours(10);
		Assert.assertEquals(upperExpected, clock.getUpperHour());
		Assert.assertEquals(lowerExpected, clock.getLowerHour());
	}
	
	@Test
	public void testTheHourof8isOneAndThreeBlocks() {
		Integer lowerExpected = 3;
		Integer upperExpected = 1;
		
		clock.getHours(8);
		Assert.assertEquals(upperExpected, clock.getUpperHour());
		Assert.assertEquals(lowerExpected, clock.getLowerHour());
	}
	
	@Test
	public void testTheHourof11isTwoAndOneBlock() {
		Integer lowerExpected = 1;
		Integer upperExpected = 2;
		
		clock.getHours(11);
		Assert.assertEquals(upperExpected, clock.getUpperHour());
		Assert.assertEquals(lowerExpected, clock.getLowerHour());
	}
	
	@Test
	public void testTheMinutesof51isTenAndOneBlock() {
		Integer lowerExpected = 1;
		Integer upperExpected = 10;
		
		clock.getMinutes(51);
		Assert.assertEquals(upperExpected, clock.getUpperMinutes());
		Assert.assertEquals(lowerExpected, clock.getLowerMinutes());
	}
	
	@Test
	public void testTheMinutesof22isFourAndTowBlocks() {
		Integer lowerExpected = 2;
		Integer upperExpected = 4;
		
		clock.getMinutes(22);
		Assert.assertEquals(upperExpected, clock.getUpperMinutes());
		Assert.assertEquals(lowerExpected, clock.getLowerMinutes());
	}
	
	@Test
	public void testTheSecondsOf22isX() {
		String secondsExpected = "X";
		
		clock.getSeconds(22);
		
		Assert.assertEquals(secondsExpected, clock.getSecondsDisplay());
	}
	
	@Test
	public void testTheSecondsOf13is0() {
		String secondsExpected = "-";
		
		clock.getSeconds(13);
		
		Assert.assertEquals(secondsExpected, clock.getSecondsDisplay());
	}
	
	@Test
	public void testHour10() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("X");
		expected.add("X");
		expected.add("-");
		expected.add("-");
		clock.getHours(10);
		clock.writeTimeComponent(clock.getHourUpperDisplay(),2);
		
		Assert.assertEquals(expected, clock.getHourUpperDisplay());
	}
	
	@Test
	public void testTime() {
		StringBuilder expectedTime = new StringBuilder();
		clock.getTime(10, 22, 11);
		
		expectedTime.append("[-]");
		expectedTime.append("\n");
		expectedTime.append("[XX--]");
		expectedTime.append("\n");
		expectedTime.append("[----]");
		expectedTime.append("\n");
		expectedTime.append("[XXXX-------]");
		expectedTime.append("\n");
		expectedTime.append("[XX--]");
		
		
		Assert.assertEquals(expectedTime.toString(), clock.displayTime());
	}
}
