package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HourContract {
	
	private Date date; 
	private Double valuePerHour; 
	private Integer hours;
	
	public HourContract(Date date, Double valuePerHour, Integer hours) {
		
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	public double totalValue() {
		return this.hours * this.valuePerHour;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return "HourContract [Date = " + sdf.format(date) 
				+ ", Value Per Hour = $" + String.format("%.2f", valuePerHour) 
				+ ", Hours = " + hours + "]";
	}
}
