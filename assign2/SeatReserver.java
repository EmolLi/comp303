import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SeatReserver implements Runnable{
	private int ID;
	private Seats seats;
	private SelectionPage gui;
	
	private static final int DELAY1 = 100;
	
	public SeatReserver(int ID, Seats seats, SelectionPage gui){
		this.ID = ID;
		this.seats = seats;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		if (ID == 3){
			getUserSelection();
		}

		
		
		else try{
		
			while(seats.getEmptySeat()>0){
					runAutoThread();
					Thread.sleep(DELAY1);
			}
		}catch(InterruptedException e){
			
		}
	}
	
		
	
	public void runAutoThread(){
		int n = (int)(200* Math.random());
		try{
			seats.reservSeat(n, ID);
			Seat s = seats.getSeatList().get(n);
			if (ID == s.getOwner()) updateGui(s.getRow(),s.getCol(), ID);
		}
		catch (InterruptedException e){
		}
		
	}
	
	
	public ActionListener listener(int row, int col){
		return new ActionListener(){
			public void actionPerformed(ActionEvent event){
				try {
					if (seats.reservSeat(4*row+col, ID)){
						Seat s = seats.getSeatList().get(4*row+col);
						if (ID == s.getOwner()) updateGui(s.getRow(),s.getCol(), ID);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}
	
	private void getUserSelection(){
		JButton[][] seatButtons = gui.getButtons();
		for (int i = 0; i<50; i++){
			for (int j = 0; j<4; j++){
				seatButtons[i][j].addActionListener(listener(i,j));
			}
		}
	}
	
	
	private void updateGui(int row, int col, int prodID){
		JButton[][] seatButtons = gui.getButtons();
		seatButtons[row][col].setText(""+prodID);
		return;
	}

}
	


