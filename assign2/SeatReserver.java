import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * producer thread
 * @author emol
 *
 */
public class SeatReserver implements Runnable{
	/**
	 * ID: 1 or 2, automatic thread
	 * ID: 3, manual thread 
	 */
	private int ID;
	private Seats seats;
	private SelectionPage gui;
	
	private static final int DELAY1 = 100;
	
	/**
	 * Constructor
	 * @param ID	the ID of the thread/producer, 1 or 2 : automatic thread; 3: manual thread
	 * @param seats	the list of all the seats
	 * @param gui	the gui of the selection page
	 */
	public SeatReserver(int ID, Seats seats, SelectionPage gui){
		this.ID = ID;
		this.seats = seats;
		this.gui = gui;
	}
	
	@Override
	public void run() {
		/**
		 * manual thread
		 */
		if (ID == 3){
			getUserSelection();
		}

		
		/**
		 * automatic thread
		 */
		else try{
		
			while(seats.getEmptySeat()>0){
					runAutoThread();
					Thread.sleep(DELAY1);
			}
		}catch(InterruptedException e){
			
		}
	}
	
		
	/**
	 * Run the automatic thread, which reserve seats automatically
	 */
	private void runAutoThread(){
		int n = (int)(200* Math.random());
		try{
			seats.reservSeat(n, ID);
			Seat s = seats.getSeatList().get(n);
			if (ID == s.getOwner()) updateGui(s.getRow(),s.getCol(), ID);
		}
		catch (InterruptedException e){
		}
		
	}
	
	/**
	 * Action Listener for the button.
	 * When the user click a button, it notifies the system that the user want to reserve the seat the button represents
	 * @param row the row number of the seat/button
	 * @param col the col number of the seat/button
	 * @return the action listener
	 */
	private ActionListener listener(int row, int col){
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
	
	/**
	 * add the action Listener to the buttons
	 */
	private void getUserSelection(){
		JButton[][] seatButtons = gui.getButtons();
		for (int i = 0; i<50; i++){
			for (int j = 0; j<4; j++){
				seatButtons[i][j].addActionListener(listener(i,j));
			}
		}
	}
	
	
	/**
	 * update the GUI when a thread successfully reserve a seat
	 * @param row the row number of the seat
	 * @param col the col number of the seat
	 * @param prodID the producer ID
	 */
	private void updateGui(int row, int col, int prodID){
		JButton[][] seatButtons = gui.getButtons();
		seatButtons[row][col].setText(""+prodID);
		return;
	}

}
	


