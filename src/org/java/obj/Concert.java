package org.java.obj;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {
	private LocalTime time;
	private BigDecimal price;

	public Concert(String title, LocalDate date, int totalSeats, LocalTime time, BigDecimal price) throws Exception {
		super(title, date, totalSeats);
		setTime(time);
		setPrice(price);
	}

	//time
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getFormattedTime() {
		return time.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	//price
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getFormattedPrice() {
		return NumberFormat.getCurrencyInstance().format(getPrice());
	}
	
	@Override
	public String getFormattedDate() {
		return super.getFormattedDate() + " " + getFormattedTime();
	}
	
	@Override
	public String toString() {
		return getFormattedDate() + " - " + getTitle() + " - " + getFormattedPrice();
	}
	
	
}
