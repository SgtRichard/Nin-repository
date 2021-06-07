package mod;

public class Harpy {
	
	//the position of the Harpy and whether or not it is alive
	private int _row, _col;
	private boolean _isAlive;
	
	//getters and setters for the Harpy's position
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//Harpy class constructor where it is given a position and told whether or not it is alive
	public Harpy(int r, int c, boolean b) {
		_row = r;
		_col = c;
		_isAlive = b;
	}
	
	//getter for whether or not the Harpy is alive
	public boolean isAlive() { return _isAlive; }
	//method used to kill the Harpy
	public void kill() {_isAlive = false;}
}
