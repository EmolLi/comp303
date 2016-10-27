import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Seats keeps track of all seats 
 * @author emol
 *
 */
public class Seats {
	private List<Seat> seats;
	private int emptySeat;
	private Lock lock = new ReentrantLock();
	
	/**
	 * constructor for Seats
	 * @param gui, the selection page
	 */
	public Seats(SelectionPage gui){
		seats = new ArrayList<Seat>();
		for (int i = 0; i<200; i++){
			Seat s = new Seat(i);
			seats.add(s);
		} 
		emptySeat = 200;
	}
	

	/**
	 * @return the amount of empty seats
	 */
	public int getEmptySeat(){
		return emptySeat;
	}
	
	/**
	 * 
	 * @return the list of all the seats
	 */
	public List<Seat> getSeatList(){
		return seats;
	}

	
	/**
	 * this method reserve a seat for producer with prodID
	 * @param i the id of the seat the thread try to reserve
	 * @param prodID the id of the producer thread
	 * @throws InterruptedException
	 */
	public boolean reservSeat(int i, int prodID) throws InterruptedException{
		lock.lock();
		try{
			if (emptySeat == 0) return false;
			Seat s = seats.get(i);
			if (s.getOwner() != -1) {
				return false;
			}
			s.setOwner(prodID);
			emptySeat--;
			return true;
		}
		finally{
			lock.unlock();
		}
	}
}