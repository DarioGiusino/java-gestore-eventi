package org.java.main;

import java.time.LocalDate;

import org.java.obj.Event;

public class Main {
	public static void main(String[] args) {
		try {
			Event e1 = new Event("Big fish", LocalDate.of(2023, 4, 18), 2000);
			System.out.println(e1);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		
	}
}
