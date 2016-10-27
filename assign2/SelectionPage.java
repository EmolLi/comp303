import java.awt.GridLayout;

import javax.swing.*;
/**
 * This class set up the GUI for the selection page
 * @author emol
 *
 */
public class SelectionPage {
	private JFrame f;
	private JButton seatbuttons[][];
	
	/**
	 * Constructor
	 * set up all 200 buttons to represent the seats
	 */
	public SelectionPage(){
		f = new JFrame();
		seatbuttons= new JButton[50][4];
		for (int i = 0; i< 50; i++){
			for (int j = 0; j<4; j++){
				seatbuttons[i][j]= new JButton(" ");
				f.add(seatbuttons[i][j]);
			}
		}
		f.setLayout(new GridLayout(50,4));
		f.setSize(170, 1000);
		f.setVisible(true);
		
	}
	
	/**
	 * 
	 * @return the frame
	 */
	public JFrame getFrame(){
		return f;
	}
	/**
	 * 
	 * @return the 2D array of buttons that represents the seats
	 */
	public JButton[][] getButtons(){
		return seatbuttons;
	}
	
}
