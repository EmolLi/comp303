package leetcode;
public class Main {
	public static void main(String[] args){
		Seats seats = new Seats();
		
		Runnable run1 = new SeatReserver(1, seats);
		Runnable run2 = new SeatReserver(2, seats);
		Runnable run3 = new SeatReserver(3, seats);
		
		Thread thread1 = new Thread(run1);
		Thread thread2 = new Thread(run2);
		Thread thread3 = new Thread(run3);
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}
}