import java.awt.GridLayout;

import javax.swing.*;
public class SelectionPage {
	private JFrame f;
	private JButton seatbuttons[][];
	
	
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
	
	public JFrame getFrame(){
		return f;
	}
	public JButton[][] getButtons(){
		return seatbuttons;
	}
	
}
