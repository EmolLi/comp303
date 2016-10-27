import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Seats {
	private List<Seat> seats;
	private int emptySeat;
	private Lock lock = new ReentrantLock();
	
	public Seats(SelectionPage gui){
		seats = new ArrayList<Seat>();
		for (int i = 0; i<200; i++){
			Seat s = new Seat(i);
			seats.add(s);
		}
		emptySeat = 200;
	}
	

	
	public int getEmptySeat(){
		return emptySeat;
	}
	
	public List<Seat> getSeatList(){
		return seats;
	}

	
	/**
	 * 
	 * @param i the id of the seat the thread try to reserve
	 * @throws SeatReserved 
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