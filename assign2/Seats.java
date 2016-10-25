package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Seats {
	private List<Seat> seats;
	private int emptySeat;
	private Lock lock = new ReentrantLock();
	private Condition emptySeatAvail = lock.newCondition();
	
	public Seats(){
		seats = new ArrayList<Seat>();
		for (int i = 0; i<200; i++){
			Seat s = new Seat(i);
			seats.add(s);
		}
		emptySeat = 200;
	}
	
	/**
	 * 
	 * @param i the id of the seat the thread try to reserve
	 * @throws SeatReserved 
	 */
	public void reservSeat(int i, int prodID) throws InterruptedException{
		lock.lock();
		try{
			while (emptySeat == 0){
				System.out.println("FUll");
				emptySeatAvail.await();
			}
			Seat s = seats.get(i);
			//already reserved
			if (s.getOwner() != -1) {
				//System.out.println("the seat is already reserved");
				return;
			}
			s.setOwner(prodID);
			System.out.println("reserved: "+i+"  "+prodID);
			emptySeat--;
		}
		finally{
			lock.unlock();
		}
	}
}
