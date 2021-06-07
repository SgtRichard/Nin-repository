package mod;

import cont.JOP;
import view.Sound;

public class Main {

	@SuppressWarnings("unused")
	//the main method, first plays some music and gives messages regarding what each icon is on the
	//text map for the player to understand better, then the game begins
	public static void main(String[] args) throws InterruptedException {
		Sound sound = new Sound("C:\\Users\\Rick\\Downloads\\8-Bit SSBKK-SSBE G&V.wav");
		JOP jop = new JOP();
		JOP.msg("Welcome to The Labyrinth \n here is a quick guide \n "
				+ "\n 'v' this is an unarmed Player Character aka(You)\n "
				+ "\n .E. the exit of the maze \n becomes unlocked when all monsters are defeated \n"
				+ "\n ,t, a sword to arm the Player \n"); 				
		JOP.msg("The labrinth has many kinds of Monsters \n "
				+ "\n ;M; this is a minotaur and they are common in the labyrinth \n"
				+ "\n !0! this one is a cyclops though they have delayed \n reaction time they make up for it with their strength\n "
				+ "\n >;< however be careful of these harpies they can fly over the labyrinth walls \n"
				+"\n `F` there is also a hidden key that will grant you freedom from this Labyrinth\n");
		World obj = new World(JOP.Level());
	}

}
