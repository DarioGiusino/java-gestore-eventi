package org.java.obj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EventPlan {
	private String title;
	private List<Event> events = new ArrayList<>();
	
	public EventPlan(String title) {
		setTitle(title);
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	//add and event
	public void addEvent(Event event) {
		events.add(event);
	}
	
	//print events list
	public void printEvents() {
		System.out.println(events);
	}
	
	//return number of events
	public Integer countEvents() {
		return events.size();
	}
	
	//clear events list
	public void cleanEvents() {
		events.clear();
	}
	
	@Override
	public String toString() {
		
		Collections.sort(events, new Comparator<Event>() {
			  public int compare(Event o1, Event o2) {
			      if (o1.getDate() == null || o2.getDate() == null)
			        return 0;
			      return o1.getDate().compareTo(o2.getDate());
			  }
			});
		
		String s = "";
		
		for(Event event : events) {
			s += event + "\n";
		}
		
		return "Titolo: " + getTitle()
			+ "\n" + s;
	}
}
