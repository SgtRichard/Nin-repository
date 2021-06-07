package mod;

public class Player {
	
	//various variables that represent the player's position, whether or not they have the key,
	//whether or not they are alive, and whether or not they have the sword
	private int _row, _col;
	private boolean _key;
	private boolean _isAlive;
	private boolean _sword;
	//a Maze object is created and initialized
	private Maze _m = new Maze();
	
	//getters and setters for the player's position
	public int getRow() { return _row; }
	public int getCol() { return _col; }
	public void setPos(int r, int c) { _row = r; _col = c; }
	
	//the Player class constructor which establishes a position for the player and instantly states that
	//they are alive and have the sword but whether or not they have the key is up to the parameter
	public Player(int r, int c, boolean a) {
		_row = r;
		_col = c;
		_isAlive = true;
		_sword = true;
		_key = a;
	}
	//getter for whether or not the player is alive
	public boolean isAlive() { return _isAlive; }
	//method to kill the player
	public void kill() { _isAlive = false; }
	//getter for whether or not the player has the sword
	public boolean hasSword(){return _sword;}
	
	//a method that removes the sword from the map if the player picks it up
	public void giveSword()
	{
		if(World.getI() == 1 &&_m.getSword()[0] == getRow() && _m.getSword()[1] == getCol()){_sword = false;}
		if(World.getI() == 2 &&_m.getSword()[2] == getRow() && _m.getSword()[3] == getCol()){_sword = false;}
		if(World.getI() == 3 &&_m.getSword()[4] == getRow() && _m.getSword()[5] == getCol()){_sword = false;}
	}
	//a method similar to the one prior except applies to the key, removing it the same way
	public void giveKey()
	{
		if(World.getI() == 3 &&_m.getKey()[0] == getRow() && _m.getKey()[1] == getCol()){_key = false;}
	}
	//getter method for whether or not the player has the key
	public boolean hasKey() {return _key;}
}
