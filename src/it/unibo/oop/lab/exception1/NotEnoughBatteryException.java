package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double batteryLevel;
	private double batteryRequired;
	
	
	public NotEnoughBatteryException(double batteryLevel, double batteryRequired) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteryRequired = batteryRequired;
	}
	
	
	public String toString() {
		return "The battery level (" + this.batteryLevel + "%) isn't enough for movement, "
				+ "the minimum level battery requested for movement is " + this.batteryRequired +"%!!!";
	}
	
	public String getMessage(){
		return this.toString();	
	}
	
}
