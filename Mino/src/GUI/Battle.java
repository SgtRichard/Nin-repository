package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class Battle extends JPanel {

	//creates objects for the player, minotaur, and maze, while also creating JLabels for the
	//player's health, minotaur's health, JButtons for the different attacks, and the JPanel
	//to store it all
	Player knight;
	Minotaur mino;
	Maze _maze;
	JLabel hpc;
	JLabel hpm;
	JPanel battle;
	JButton attack1; 
	JButton attack2;
	JButton attack3;
	
	//the Battle class constructor, calling on the super class to create a JPanel, and initiazilizng the various
	//objects that were declared earlier.
	public Battle(int width, int height, Player p){
		super();
		//uses the Player parameter to give a value to the knight class
		knight = p;
		//knight = new Player(6,6);
		//initializes the minotaur object, giving it a position in the parameters, and also sets the minotaur's health
		//to what it should be after the player's turn is over (so no change if the battle has just begun)
		mino = new Minotaur(6,6);
		mino.setHp(GUI.minoHp);
		
		//initializing the JPanel
		setVisible(true);
		setSize(width, height);
		setLayout(null);
		//initializing the three JButtons as different attacks, swipe, swing, and stab.
		attack1 = new JButton("Swipe");
		attack2 = new JButton("Stab");
		attack3 = new JButton("Swing");
	
	
		//further initializing the JButtons, making each have a unique position, and each does a unique
		//amount of damage to the minotaur, and if the player dies or the minotaur dies a message is played saying that,
		//the player won or lost, but if both died the player still loses.
		attack1.setLayout(null);
		attack1.setLocation(150, 700);
		attack1.setSize(100, 50);
		attack1.setVisible(true);
		attack1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				attack1();
				hpm.setText(mino.getHp()+"" );
				hpc.setText(knight.getHp()+"");
				if(knight.getHp()<= 0) {
					JOptionPane.showMessageDialog(null, "You died. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				if(mino.getHp()<=0) {
					System.out.println(knight.getCunt());
					JOptionPane.showMessageDialog(null, "You won. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				
			}

			private void JOptionPane(String string) {
				// TODO Auto-generated method stub
				
			}
		
		});
		add(attack1);
	
		attack2.setLayout(null);
		attack2.setLocation(400, 700);
		attack2.setSize(100, 50);
		attack2.setVisible(true);
		attack2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				attack2();
				hpm.setText(mino.getHp()+"" );
				hpc.setText(knight.getHp()+"");
				if(knight.getHp()<= 0) {
					JOptionPane.showMessageDialog(null, "You died. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				if(mino.getHp()<=0) {
					System.out.println(knight.getCunt());
					JOptionPane.showMessageDialog(null, "You won. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				
			}
		});
		add(attack2);
	
		attack3.setLayout(null);
		attack3.setLocation(650, 700);
		attack3.setSize(100, 50);
		attack3.setVisible(true);
		attack3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			
				attack3();
				hpm.setText(mino.getHp()+"" );
				hpc.setText(knight.getHp()+"");
				if(knight.getHp()<= 0) {
					JOptionPane.showMessageDialog(null, "You died. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				if(mino.getHp()<=0) {
					System.out.println(knight.getCunt());
					JOptionPane.showMessageDialog(null, "You won. You took this many steps!!! " + knight.getCunt());
					System.exit(0);
				}
				
			}
		});
		add(attack3);
	
		//initializing the JLabels that display the player's health and the minotaur's health to the screen, in 
		//differing spots.
		hpc = new JLabel(knight.getHp()+"");
		hpc.setLayout(null);
		hpc.setVisible(true);
		hpc.setSize(100, 50);
		hpc.setLocation(70, 330);
		add(hpc);
		
		hpm= new JLabel(mino.getHp()+"");
		hpm.setLayout(null);
		hpm.setVisible(true);
		hpm.setSize(100, 50);
		hpm.setLocation(630, 20);
		add(hpm);

		//makes an ImageIcon that has the image that represents the player, and adds
		//that ImageIcon to a JLabel that is the player
		ImageIcon knight = new ImageIcon("src/GUI/KnightBattle.jpg");
		JLabel player = new JLabel(knight);
		player.setLayout(null);
		player.setVisible(true);
		player.setSize(215, 235);
		add(player);
		player.setLocation(70, 380);
	
	
		//makes an ImageIcon that has the image that represents the minotaur, and adds
		//that ImageIcon to a JLabel that is the minotaur
		ImageIcon mino = new ImageIcon("src/GUI/MinotaurBattle.jpg");
		JLabel enemy = new JLabel(mino);
		enemy.setLayout(null);
		enemy.setVisible(true);
		enemy.setSize(240, 320);
		add(enemy);
		enemy.setLocation(630, 50);
	}
	
	//three methods that represent each attack the player can do if, which each changing the minotaur's health
	//by the damage the player does to the minotaur, and changing the player's health by whatever damage the 
	//minotaur does to the player
	public void attack1() {
		mino.setHp(mino.getHp()-knight.getDmg1());
		knight.setHp((int)(knight.getHp()-20*Math.random()));
	}
	public void attack2() {
		mino.setHp(mino.getHp()-knight.getDmg2());
		knight.setHp((int)(knight.getHp()-20*Math.random()));
	}
	public void attack3() {
		mino.setHp(mino.getHp()-knight.getDmg2());
		knight.setHp((int)(knight.getHp()-20*Math.random()));
	}


}


