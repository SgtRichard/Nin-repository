package mod;

import javax.swing.JOptionPane;

import GUI.GUI;

public class Main {
	//a Gui class object is declared and then initialized in the main method, starting the game
	public static GUI gui;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//World obj = new World();
		
		//message given to the player before the game begins
		JOptionPane.showMessageDialog(null, "Welcome traveler! King Midas has challenged you to face the minotaur and escape the maze!");
		JOptionPane.showMessageDialog(null, "Your movement will be decided with the W A S D keys. If you pick up the sword you may face the minotaur in open battle. However, if you choose to cower then you may evade the minotaur and escape through the tunnel! Good luck traveler!");
		gui = new GUI();
		
		
	}

}
