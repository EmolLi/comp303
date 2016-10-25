package leetcode;

import java.util.Scanner;

public class SeatReserver implements Runnable{
	private int ID;
	private Seats seats;
	
	private static final int DELAY = 10;
	
	public SeatReserver(int ID, Seats seats){
		this.ID = ID;
		this.seats = seats;
	}
	
	@Override
	public void run() {
		while(true){
		if (ID == 3){
				runManuThread();
		}
		else{
				runAutoThread();
		}
		try {
			Thread.sleep((int)Math.random()*DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void runManuThread(){
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a seat number between 0-199: ");
		int n = reader.nextInt();
		reader.close();
		if (n<0 || n>=200){
			System.out.println("Invalid seat number");
			return;
		}
		try{
			seats.reservSeat(n, ID);
		}
		catch (InterruptedException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	public void runAutoThread(){
		int n = (int)(200* Math.random());
		try{
			seats.reservSeat(n, ID);
		}
		catch (InterruptedException e){
		}
		
	}
	

}
