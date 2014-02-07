package parkinglot;

public class Vehicle {

	private String registrationNumber;

	// Vehicle holds a single ticket
	private ParkingTicket ticket;

	public Vehicle(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public ParkingTicket getTicket() {
		return ticket;
	}

	public void setTicket(ParkingTicket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "REG: " + registrationNumber + " " + ticket;
	}

}
