package parkinglot;

import java.util.Date;
import java.util.Random;

public class ParkingGate implements ParkingLot {

	private int current_vehicles = 0;

	// Unit: msec
	private int free_parking_duration;

	private int max_lot;

	public ParkingGate(int max_lot,
			int free_parking_duration) {
		this.max_lot = max_lot;
		this.free_parking_duration = free_parking_duration;
	}

	@Override
	public ParkingTicket enter() {
		if(isFull()) {
			System.err.println("Parking is full.");
			return null;
		}
		current_vehicles++;
		Date current = new Date();
		long duetime = free_parking_duration;
		Date dueDatetime = new Date(current.getTime() + duetime);
		ParkingTicket ticket = new ParkingTicket(new Random().nextInt(10), current, dueDatetime);
		// Open gate
		return ticket;
	}

	@Override
	public boolean isFull() {
		return current_vehicles == max_lot;
	}

	@Override
	public boolean isEmpty() {
		return current_vehicles == 0;
	}

	@Override
	public void exit(ParkingTicket ticket) {
		Date now = new Date();
		if(ticket.getOutDatetime().before(now)) {
			// Issue a new charge
			System.out.println("CHARE is issued for " + ticket);
		}
		// Open gate
		current_vehicles--;
	}

	@Override
	public int vacancies() {
		return max_lot - current_vehicles;
	}

}
