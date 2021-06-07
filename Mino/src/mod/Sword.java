package mod;

import javax.swing.ImageIcon;

public class Sword {
	//two integers are declared, x and y, that will represent the x and y position of the sword object
	//in the game
	private int x,y;
	//the image used for the sword is stored in an ImageIcon object
	public ImageIcon sword = new ImageIcon("src/GUI/Sword.png");
	
	public Sword(int x, int y) {
		//using the parameter of the class constructor, the Sword object is given an x and y position
		this.x = x; 
		this.y = y;
	}
	
	//getter methods for the x position and the y position
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
