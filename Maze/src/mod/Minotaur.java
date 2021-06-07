package mod;

public class Minotaur {
	
	//the position of the Minotaur and whether or not it is alive
	private int _row, _col;
	private boolean _isAlive;
	
	//getters and setters for the Minotaur's position
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//Minotaur class constructor where it is given a position and told whether or not it is alive
	public Minotaur(int r, int c) {
		_row = r;
		_col = c;
		_isAlive = true;
	}
	
	//getter for whether or not the Minotaur is alive
	public boolean isAlive() { return _isAlive; }
	//method used to kill the Minotaur
	public void kill() {_isAlive = false;}
}
