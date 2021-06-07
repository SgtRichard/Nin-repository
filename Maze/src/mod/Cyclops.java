package mod;

public class Cyclops {

	//the position of the Cyclops and whether or not it is alive
	private int _row, _col;
	private boolean _isAlive;
	
	//getters and setters for the Cyclop's position
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//Cyclops class constructor where it is given a position and told whether or not it is alive
	public Cyclops(int r, int c, boolean b) {
		_row = r;
		_col = c;
		_isAlive = b;
	}
	
	//getter for whether or not the Cyclops is alive
	public boolean isAlive() { return _isAlive; }
	//method used to kill the Cyclops
	public void kill() {_isAlive = false;}
}
