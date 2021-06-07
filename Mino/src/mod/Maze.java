package mod;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import GUI.Battle;
import GUI.GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maze extends JPanel {
	
	//two ImageIcons are created, one that is completely black, and another that is completely white,
	//which shall represent walls and pathways respectively in the game
	private static final ImageIcon black = new ImageIcon("src/GUI/black.png");
	private static final ImageIcon white = new ImageIcon("src/GUI/white.png");
	
	//various objects are created with their own unique positions on the map, them being a
	//sword object, minotaur object, player object, and an exit object, and it is declared
	//that the player doesn't have the sword at the beginning of the game
	private Sword sword = new Sword(3,4);
	private Minotaur sad = new Minotaur(8,8);
	private Player happy = new Player(0,0);
	private Exit exit = new Exit(9,5);
	private boolean hasSword = false;
	private boolean dead = false;
	
	//getter method for the player object
	public Player getPlayer() {
		return happy;
	}
	
	//a boolean map of the maze where true values represent a pathway and false values are walls that the player
	//nor minotaur can pass through
	private boolean[][] _curMaze =
			{			
			{true , true , true , true , true , true , true , true , true , true },
			{true , false, false, false, true , false, false, true , false, true },
			{true , true , true , true , true , false, true , true , false, true },
			{true , false, false, true , false, false, true , false, false, true },
			{true , true , true , true , true , true , true , true , true , true },
			{true , true , false, true , false, true, false, false, false, true },
			{true , false, false, true , true, true , true , true , true , true },
			{true , true , true , true , true , true , false, false, true , false},
			{false, true , false, false, false, true , true , true , true , false},
			{true , true , true , true , true , true , false, false, false, false}};
	
			


	//an array of JLabels that will display the maze to the player
	private JLabel[][] _blocks = new JLabel[_curMaze.length][_curMaze[0].length];

	//a timer object that will determine how often the minotaur moves towards the player
	private Timer minoTimer = new Timer(300, new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			sad.move(happy.getX(), happy.getY(), _curMaze);
		}
	});
	
	//another timer that is reserved to updating the position of the player and minotaur on the display
	//many one time events, them being when the player escapes, giving them a message and closing the game
	//when the player gets the sword, changing the hasSword boolean to true, and if the player encounters 
	//the minotaur, whether or not the player should go into "battle" if it has the sword or if the player
	//is going to die, closing the game.
	private Timer guiTimer = new Timer(5, new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			clearImages();
			if(happy.getX() == exit.getX() && happy.getY() == exit.getY()) {
				System.exit(0);
				JOptionPane.showMessageDialog(null, "You escaped. You took this many steps!!! " + happy.getCunt());
		}	
			if(happy.getX() == sword.getX() && happy.getY() == sword.getY() && !hasSword) {
				hasSword = true;
			}
			if(sad.getX() == happy.getX() && sad.getY() == happy.getY()){
				if(hasSword && sad.getHp()>0) {
					GUI.state = "battle";
				} else if (!hasSword){
					JOptionPane.showMessageDialog(null, "You died. You took this many steps!!! " + happy.getCunt());	
					System.exit(0);
				}
				
			}
			_blocks[happy.getY()][happy.getX()].setIcon(happy.knightImage);
			_blocks[sad.getY()][sad.getX()].setIcon(sad.minotaurImage);
		}
	});

	//setter method for the health of the minotaur object that was made earlier
	public void setHp(int hp) {
		sad.setHp(hp);
	}
			
	//the constructor for the Maze class, calling the super class, JPanel, and randomly determining a
	//map for the player to play in, then setting the images in the JLabel to what it should be depending 
	//on the boolean map that is chosen, with the true values being pathways (white) and the false values
	//being walls (black)
	public Maze(int width, int height) {
		super();
		int x = (int)(Math.random()*3);
		if(x == 2) {
			_curMaze = new boolean[][]{
					{true , true , true , true , true , true , true , true , true , true },
					{true , false, true, false, false, true , false, false, false, true },
					{true , true , true , true , true, true , true , false, false, true },
					{true , false, false, true , false, false, true , true , true , true },
					{true , false, true , true , true , false, true, false, true , false},
					{true , true, true , true, true , true , true , true , true , true},
					{true , false, true , false, false, false, true , false, true , true },
					{true , false, true , false, true , true , true , true, true , false },
					{true , false, true , false, true , false, true , false, true, true },
					{true , true , true , true , true , false, true , true , true , true }
					};
			
		
		}else if(x == 1) {
			_curMaze = new boolean[][]{
			{true, false, true , true , true , false, false, true , true , true },
			{true, false, true , false, true , true , true , true , false, true },
			{true , true , true , false, false, false, false, true , false, true },
			{true , false, true , true , true , true , true , true , false, true },
			{true , false, false, true, false, false, true , true , true , true },
			{true , false, true , true , true , true , true , false, false, true },
			{true , true , true , false, false, false, true , false, true , true },
			{true , false, true , true , true , false, true , true , true , false},
			{true , false, false, false, true , false, false, false, true , false},
			{true , true , true , true , true , true , true , true , true , false}
			};
		}else {
			_curMaze = new boolean[][]{				
			{true , true , true , true , true , true , true , true , true , true },
			{true , false, false, false, true , false, false, true , false, true },
			{true , true , true , true , true , false, true , true , false, true },
			{true , false, false, true , false, false, true , false, false, true },
			{true , true , true , true , true , true , true , true , true , true },
			{true , true , false, true , false, true, false, false, false, true },
			{true , false, false, true , true, true , true , true , true , true },
			{true , true , true , true , true , true , false, false, true , false},
			{false, true , false, false, false, true , true , true , true , false},
			{true , true , true , true , true , true , false, false, false, false}
			};
		}
		setSize(width, height);
		for (int i = 0; i < _blocks.length; i++) {
			for (int j = 0; j < _blocks[0].length; j++) {
				_blocks[i][j] = new JLabel();
				_blocks[i][j].setBounds((int) (j * 1.0 / _curMaze.length * width),
						(int) (i * 1.0 / _curMaze[0].length * height), width / _curMaze.length,
						height / _curMaze[0].length);
				_blocks[i][j].setOpaque(true);
				_blocks[i][j].setLayout(null);
				if (_curMaze[i][j]) {
					_blocks[i][j].setIcon(white);
				} else {
					_blocks[i][j].setIcon(black);;
				}
				add(_blocks[i][j]);
			}		
		}
		
	}
	
	
	//a keylistener whose entire purpose is to send a value the represents what key a user pressed to 
	//the player class which determines the player's movements
	public KeyListener maze = new KeyListener() {
		
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			happy.getPlayerMove(arg0.getKeyCode(), _curMaze);
		}
		
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};
		
	//a method that is used to refresh the display, with non moving objects like the exit or walls staying
	//in the same positions.
	private void clearImages() {
		for(int i = 0; i < _curMaze.length; i++) {
			for(int j = 0; j < _curMaze[0].length; j++) {
				if (_curMaze[i][j]) {
					_blocks[i][j].setIcon(white);
				} else {
					_blocks[i][j].setIcon(black);;
				}
				if (i == sword.getY() && j == sword.getX() && !hasSword) {
					_blocks[i][j].setIcon(sword.sword);
				}
				if (i == exit.getY() && j == exit.getX()) {
					_blocks[i][j].setIcon(exit.exit);
				}
			}
		}
	}
	
	//methods to start or stop the timers that were created earlier
	public void startTimer() {
		minoTimer.start();
		guiTimer.start();
	}
	public void stopTimer() {
		minoTimer.stop();
		guiTimer.stop();
	}
	
}
