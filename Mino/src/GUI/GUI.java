package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import mod.Maze;
import mod.Minotaur;
import mod.Player;

public class GUI extends JFrame {
	
	//objects for the battle sequence, the maze, and the main menu are initialized, integers for the size of the screen
	//and the minotaur's health, and strings that determine what "state" the game is in are all declared
	private Battle _battle;
	private Maze _maze;
	private MainMenu _mainmenu;
	private final int width = 900;
	private final int height = 900;
	public static String state = "main";
	private String hiddenState = state;
	public static int minoHp = 200;
	
	//a timer that will constantly check for any changes in the game, like the user hitting a key that moves
	//the player
	private Timer detect = new Timer(1, new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			detectChange();			
		}
	});
	
	//an integer that represents what level the user is playing in
	private int level;
	//the class constructor for the GUI class
	public GUI() {
		//calls on super class (JFrame)
		super();
		//initializes JFrame
		setSize(width + 6, height + 35);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);	
		
		//initializes the MainMenu object, Maze object, and Battle object, adding the MainMenu object to the JFrame
		MainMenu menu = new MainMenu();
		_maze = new Maze(width, height);
		_battle = new Battle(width, height, _maze.getPlayer());
		_mainmenu = new MainMenu();
		add(_mainmenu);
		setResizable(false);
		setVisible(true);
		
	}

	//getter method for the level which the player is in
	public int getLevel() {
		return level;
	}
	
	//method that detects any changes in the game state and respond to any changes accordingly (like if
	//the "state" string says "battle" then the battle sequence begins
	private void detectChange() {
		if(!state.equals(hiddenState)) {
			if(state.equals("battle")){
				setBattle();
			} else if(state.equals("maze")){
				setMaze();
				if(getListeners(KeyListener.class).length == 0) {
					addKeyListener(_maze.maze);
				}
				System.out.println(getListeners(KeyListener.class).length);
			}
			hiddenState = state;
		}		
	}
	
	//stops the maze and begins the battle sequence
	public void setBattle() {
		_maze.stopTimer();
		getContentPane().removeAll();
		add(_battle);
		repaint();
	}
	
	//begins the maze by removing everything on the screen and adding only the Maze object to the JFrame,
	//setting the minotaur's health, and starting the timer that moves the minotaur
	public void setMaze() {
		getContentPane().removeAll();
		removeKeyListener(_maze.maze);
		add(_maze);
		repaint();
		addKeyListener(_maze.maze);
		_maze.setHp(minoHp);
		_maze.startTimer();
	}
	
	//the MainMenu private class 
	private class MainMenu extends JPanel{
		//creates multiple JButton to play different levels but not all of them were ever implemented
		//and a JLabel which serves as the background
		private JButton play;
		private JLabel back;
		private JButton level1;
		private JButton level2;
		private JButton level3;
		//also an integer representing the level in play is made
		private int level;
		
		//getter method for the level integer
		public int getlevel() {
			return level;
		}
		
		//the constructor for the MainMenu class
		public MainMenu() {
			//calls on the super class (JPanel)
			super();
			//initializes the JPanel
			setSize(width, height);
			setLayout(null);
			
			//sets the level to 1
			level = 1;
			
			//sets the background of the MainMenu to an image
			back = new JLabel(new ImageIcon("src/GUI/Minotaur_Back.jpg"));
			back.setSize(width,height);
			back.setLayout(null);
			back.setOpaque(true);
			
			//initializes the second JButton, allowing the player to play the first level, but 
			//the button is never added to the JPanel
			level1 = new JButton("level 1");
			level1.setLocation(50,50);
			level1.setVisible(true);
			level1.setOpaque(true);
			level1.setBackground(Color.PINK);
			level1.setForeground(Color.BLACK);
			
			level1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					level = 1; 
				}
			});
			
			//initializes the first JButton, which allows the player to play the game
			play = new JButton("Play");
			play.setBounds(width/3, 5*height/12, width/3, height/6);
			play.setOpaque(true);
			play.setFont(new Font(play.getFont().getName(), Font.BOLD, play.getHeight()*3/4));
			play.setFocusable(false);
			play.setBackground(Color.PINK);
			play.setForeground(Color.BLACK);

			
			play.addActionListener(new ActionListener() {
				//starting the game once the JButton is pressed
				public void actionPerformed(ActionEvent arg0) {
					state = "maze";
					detect.start();
				}
			});
			back.add(play);
			add(back);
		}
	}
	
	
}
