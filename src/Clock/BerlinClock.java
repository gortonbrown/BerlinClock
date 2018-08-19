package Clock;

import java.util.ArrayList;

public class BerlinClock {
	private Integer upperHour;
	private Integer lowerHour;
	private Integer upperMinutes;
	private Integer lowerMinutes;
	private String secondsDisplay;
	
	private ArrayList<String> hourUpperDisplay;
	private ArrayList<String> hourLowerDisplay;
	private ArrayList<String> minutesUpperDisplay;
	private ArrayList<String> minutesLowerDisplay;
	
	private StringBuilder time;
	
	public BerlinClock() {
		hourUpperDisplay = new ArrayList<String>();
		hourLowerDisplay = new ArrayList<String>();
		minutesUpperDisplay = new ArrayList<String>();
		minutesLowerDisplay = new ArrayList<String>();
		
		intialiseTime(hourUpperDisplay, 4);
		intialiseTime(hourLowerDisplay, 4);
		
		intialiseTime(minutesUpperDisplay, 11);
		intialiseTime(minutesLowerDisplay, 4);
		
		time = new StringBuilder();
	}
	
	private void intialiseTime(ArrayList<String> timeComponent, Integer size){
		for (int i=0; i < size; i++) {
			timeComponent.add(i, "-");
		}
	}
	
	public Integer getUpperMinutes() {
		return upperMinutes;
	}

	public Integer getLowerMinutes() {
		return lowerMinutes;
	}

	public void getTime(Integer hour, Integer minutes, Integer seconds){
		getSeconds(seconds);
		getHours(hour);
		getMinutes(minutes);
	}
	
	private void writeTime(ArrayList<String> timeSlot) {
		time.append("[");
		timeSlot.forEach((slot) -> {
			time.append(slot.toString());
		});
		time.append("]");
	}
	
	public void getHours(Integer hour) {		
		lowerHour = hour % 5;
		upperHour = hour / 5;
	}

	public Integer getUpperHour() {
		return upperHour;
	}

	public Integer getLowerHour() {
		return lowerHour;
	}
	
	public void writeTimeComponent(ArrayList<String> timeComponent, Integer timeIndicator) {
		for (int i=0; i < timeIndicator; i++){
			timeComponent.set(i, "X");
		}
		
		writeTime(timeComponent);
	}
	
	public void getMinutes(Integer minutes) {
		upperMinutes = minutes / 5;
		lowerMinutes = minutes % 5;
	}
	
	public void getSeconds(Integer seconds) {
		if (seconds % 2  ==  0)
			secondsDisplay = "X";
		else
			secondsDisplay = "-";
	}
	
	public String getSecondsDisplay() {
		return secondsDisplay;
	}
	
	public ArrayList<String> getHourUpperDisplay(){
		return hourUpperDisplay;
	}
	
	public String displayTime() {
		time.append("["+getSecondsDisplay()+"]");
		time.append("\n");
		writeTimeComponent(hourUpperDisplay, upperHour);
		time.append("\n");
		writeTimeComponent(hourLowerDisplay, lowerHour);
		time.append("\n");
		writeTimeComponent(minutesUpperDisplay, upperMinutes);
		time.append("\n");
		writeTimeComponent(minutesLowerDisplay, lowerMinutes);
		
		return time.toString();
	}
}
