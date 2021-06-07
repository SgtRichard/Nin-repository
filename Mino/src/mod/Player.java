package mod;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	//multiple integers and one boolean being declared and/or initialized, with there being a counter (cnt), an integer
	//representing the player's health, two integers representing the damage the player can do, and a boolean that
	//will determine whether or not the player blocked an attack.
	private int cnt;
	private int _hp = 100;
	private final int _dmg1 = 25;
	private final int _dmg2 = 50;
	private boolean _block = false;
	
	//the image used for the player in the game is stored in an ImageIcon
	public final ImageIcon knightImage = new ImageIcon("src/GUI/Knight.jpg");
	
	//getter methods for the player's health, damage for different attacks, whether or not they blocked, and whether
	//or not they have the sword.
	public int getHp() { return _hp;}
	public int getDmg1() { return _dmg1;}
	public int getDmg2() { return _dmg2;}
	public boolean getBlock() { return _block;}
	public boolean getSword() { return _sword;}
	
	//setter methods for the health of the player, whether or not the player has blocked an attack, and whether 
	//or not the player has the sword
	public void setHp(int hp) {
		_hp=hp;
	}
	public void setBlock(boolean block) {
		_block=block;
	}
	public void setSword(boolean sword)	{
		_sword = sword;
	}
	
	//a getter method for the counter integer from earlier, has an inappropriate name
	public int getCunt() {
		return cnt;
	}
	
	
	
	//code for the maze, has x and y positions for the player, booleans determining whether the player is alive and
	//whether the player has a sword, getter methods for the x and y position of the player, and a method to move 
	//the player across the maze depending on what key the user presses
	private int x, y;
	private boolean _isAlive;
	private boolean _sword;
	private boolean hasSword = false;
	public int getX() { return x; }
	public int getY() { return y; }
	public void getPlayerMove(int key, boolean[][] maze) {

		//Moving the player north
		if (key == KeyEvent.VK_W) {
			if ((y - 1) >= 0 && maze[y - 1][x]) {
				y--;
				cnt++;
				System.out.println(cnt);
			}
		}
		//Moving the player south
		if (key == KeyEvent.VK_S) {
			if ((y + 1) < maze.length && maze[y + 1][x]) {
				y++;
				cnt++;
			}
		}	
		//Moving the player east
		if (key == KeyEvent.VK_D) {
			if ((x + 1) < maze[0].length && maze[y][x + 1]) {
				x++;
				cnt++;
			}
		}	
		//Moving the player west
		if (key == KeyEvent.VK_A) {
			if ((x - 1) >= 0 && maze[y][x - 1]) {
				x--;
				cnt++;
			}
		}

	}
	
	//the constructor for the player class, sets the player's position using the parameters, sets the counter to zero,
	//and sets the player to "alive"
	public Player(int r, int c) {
		//maze code	
		x = r;
		y = c;
		_isAlive = true;
		cnt = 0;
		
	}
	
	//getter method for the boolean that determines whether the player is alive, and a method that kills the player,
	//making the same boolean false
	public boolean isAlive() { return _isAlive; }
	public void kill() { _isAlive = false; }
	// hasSword(), giveSword();
}
	
