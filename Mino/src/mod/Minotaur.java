package mod;

import javax.swing.ImageIcon;

public class Minotaur {
	//creates integers that represent the minotaur's health and damage
	private int _dmg1 = 20;
	private int _hp = 200;
	
	//creates an ImageIcon that will hold the image that represents the minotaur
	public final ImageIcon minotaurImage= new ImageIcon("src/GUI/Minotaur.jpg");
	
	//getter methods for the damage and health of the minotaur
	public int getDmg1() { return _dmg1; }
	public int getHp() { return _hp; }
	
	//setter method to change the health of the minotaur
	public void setHp(int hp) {
		_hp=hp;
	}
	
	//two integers that represent the minotaur's x and y position and a boolean
	//that determines whether or not the minotaur is alive are created
	private int x, y;
	private boolean _isAlive;
	
	//getter methods for the x and y position of the minotaur
	public int getX() { return x; }
	public int getY() { return y; }
	
	//constructor for the minotaur class, uses the parameters for the x and y coordinates, and 
	//automatically sets the minotaur to "alive"
	public Minotaur(int r, int c) {
		
		x = r;
		y = c;
		_isAlive = true;
	}
	//method that determines how the minotaur should move by using the players postition
	//and its own position to see the quickest path to get to the player
	public void move(int px, int py, boolean[][] maze) {
		int xDist = px - x;
		int yDist = py - y;
		
		//Minotaur moving North
		if(yDist < 0 && maze[y - 1][x]) {
			y--;
		}

		//Minotaur moving South.
		else if(yDist > 0 && maze[y + 1][x]) {
			y++;
		}
		//Minotaur moving East
		else if(xDist > 0 && maze[y][x + 1]) {
			x++;
		}
		//Minotaur is moving west
		else if(xDist < 0 && maze[y][x - 1]) {
			x--;
		}
	}
	
	//getter method for the boolean that checks if the minotaur is alive
	public boolean isAlive() { return _isAlive; }
	// public void kill() {}
	
	
}
