package parkinglot;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Immutable Parking Ticket
 * 
 * @author ktakemur
 * 
 */
public class ParkingTicket {

	private int ticketId;

	private Date inDatetime;

	private Date outDatetime;

	public ParkingTicket(int ticketId, Date inDatetime, Date outDatetime) {
		this.ticketId = ticketId;
		this.inDatetime = inDatetime;
		this.outDatetime = outDatetime;
	}

	public Date getInDatetime() {
		return inDatetime;
	}

	public Date getOutDatetime() {
		return outDatetime;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/DD hh:mm:ss.SSS");

	@Override
	public String toString() {
		return "TicketId :" + ticketId + " IN: " + sdf.format(inDatetime) + " OUT: "
				+ sdf.format(outDatetime);
	}

}
