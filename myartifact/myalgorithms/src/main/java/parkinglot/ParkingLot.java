package parkinglot;


public interface ParkingLot {

	ParkingTicket enter();

	boolean isFull();

	boolean isEmpty();

	void exit(ParkingTicket ticket);

	int vacancies();

}
