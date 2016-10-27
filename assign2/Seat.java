/**
 * Seat object, store data about seat
 * @author emol
 *
 */
public class Seat {
	private int owner;
	private int ID;
	private int row;
	private int col;
	
	/**
	 * Constructor for Seat
	 * @param i the index for the seat
	 */
	public Seat(int i){
		ID = i;
		row = i/4;
		col = i%4;
		owner = -1;
	}

	/**
	 * 
	 * @return the row number of the seat
	 */
	public int getRow(){
		return row;
	}
	
	/**
	 * 
	 * @return the col number of the seat
	 */
	public int getCol(){
		return col;
	}
	
	/**
	 * 
	 * @return the index of the seat
	 */
	public int getID(){
		return ID;
	}
	
	/**
	 * 
	 * @return the owner of the seat. return -1 if unreserved.
	 */
	public int getOwner(){
		return owner;
	}
	
	/**
	 * set the owner of the seat to the producer with ID o
	 * @param o producer ID
	 */
	public void setOwner(int o){
		owner = o;
	}
	
}