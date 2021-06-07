package mod;

import javax.swing.ImageIcon;

public class Exit {
	//integers that represent the x and y coordinates of the exit to the maze
	private int x,y;
	
	//an ImageIcon is created to store the image that represents the maze's exit
	public ImageIcon exit = new ImageIcon("src/GUI/Exit.png");
	
	//the constructor for the Exit class, gives the exit an x and y coordinate that is 
	//dependent on the parameters
	public Exit(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//getter methods for the x and y position of the exit
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
