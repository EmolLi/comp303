package leetcode;

public class Seat {
	private int owner;
	private int ID;
	private int row;
	private int col;
	
	public Seat(int i){
		ID = i;
		row = i/4;
		col = i%4;
		owner = -1;
	}

	public int getRow(){
		return row;
	}
	
	public int getCol(){
		return col;
	}
	
	public int getID(){
		return ID;
	}
	
	public int getOwner(){
		return owner;
	}
	
	public void setOwner(int o){
		owner = o;
	}
	
}
