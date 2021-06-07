package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.Timer;



public class Gui extends JFrame {

	//Declaring integers for the height and weight and declaring a MainMenu object and a Game object
	private final int width;
	private final int height;
	private MainMenu menu;
	public Game game;
	
	public Gui() {
		//since this class extends JFrame, this constructor is creating a JFrame
		super("Stock Broker Game Thingy Simulator yes");
		
		//JFrame being initialized
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
       
		setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,screen.width,screen.height);
        setLayout(null);
        setResizable(false);
        
        //initializes the final integers width and height
        this.setVisible(true);
        width = getWidth() - getInsets().left - getInsets().right;
        height = getHeight() - getInsets().top - getInsets().bottom;
        this.setVisible(false);
		
        //initializing the MainMenu and Game objects declared earlier
        //but only adding the MainMenu object to the JFrame.
		menu = new MainMenu();
		game = new Game();
		add(menu);
		setVisible(true);
		
		
		
	}
	
	//The MainMenu private class, serves as, the name suggests, the main menu of the game. allowing the user
	//to either play or exit
	private class MainMenu extends JPanel {


		//two JButtons are declared, one named play, to play the game, and the other named exit, to exit the game.
		private JButton play;
		private JButton exit;

		//the class constructor for MainMenu
		public MainMenu() {
			//calls the super class of the JPanel, which creates a JPanel for the menu
			super();
			//sets the sizes of the JPanel to the values created in the Gui class, 
			//which is the size of the user's screen
			setSize(width, height);
			setLayout(null);

			//givng the play JButton a distinct position and a differing color (white) from the background
			//(gray) and also giving the JButton a black border to contrast against the gray background and 
			//white buttons.
			setBackground(new Color(50, 50, 50));
			play = new JButton("Play");
			play.setSize(width / 3, 2 * height / 9);
			play.setLocation(width / 3, 2 * height / 9);
			play.setOpaque(true);
			play.setFocusable(false);
			play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			play.setIcon(new ImageIcon(""));
			play.setFont(new Font(getFont().getName(), Font.BOLD, height / 7));
			play.setBackground(Color.WHITE);
			
			//giving functionality to the JButton, makes it so that when the JButton is pressed by the user,
			//the screen changes from the main menu to the game, by removing all the "content" on the screen
			//and replacing it with the "content" from the Game class object, game.
			play.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Main.gui.getContentPane().removeAll();
					Main.gui.add(game);
					Main.gui.repaint();
									}
			});
			//adding the play JButton to the JPanel
			add(play);

			//same as before with the "play" JButton, this JButton is given its own position, dimensions, and
			//coloring to differentiate it from the gray background.
			exit = new JButton("Exit");
			exit.setSize(width / 3, 2 * height / 9);
			exit.setLocation(width / 3, 5 * height / 9);
			exit.setOpaque(true);
			exit.setFocusable(false);
			exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			exit.setIcon(new ImageIcon(""));
			exit.setFont(new Font(getFont().getName(), Font.BOLD, height / 7));
			exit.setBackground(Color.WHITE);
			//giving functionality to the "exit" JButton, simply closes the program when clicked.
			exit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
					
				}
			});
			
			add(exit);

			setVisible(true);
		}
	}
	
	//another private class which will create the actual game being played
	private class Game extends JPanel{
		
		//two JLabels and one JTable are declared, with the JLabels serving as the background that has
		//a drawing of the map and a list that will contain the JTable that the user can edit.
		private JLabel background;
		private JLabel list;
		private JTable hikes;
		
		//class constructor for Game
		public Game(){
			//calls on the super class, it being JPanel, meaning that a Game object will create a 
			//JPanel when initialized. Also makes the JPanel the size of the user's screen.
			super();
			setSize(width, height);
			setLayout(null);
			
			//Creates an ImageIcon, map, that will be added as the background of the game.
			ImageIcon map = new ImageIcon("src/Images/HONQZPi.png");
			map = new ImageIcon(map.getImage().getScaledInstance(width*3/4, height, Image.SCALE_DEFAULT));
			//initializes the background JLabel, does with the ImageIcon map as a parameter for the JLabel constructor.
			background = new JLabel(map);
			background.setSize(width*3/4, height);
			background.setLayout(null);
			background.setBackground(Color.WHITE);
			background.setOpaque(true);
			background.setVisible(true);
			add(background);
			
			//initializing the list JLabel
			list = new JLabel();
			list.setSize(width/4, height);
			list.setLocation(3*width/4, 0);
			list.setLayout(null);
			list.setBackground(Color.WHITE);
			list.setOpaque(true);
			
			

			

			
			//The names of each column in the JTable created later on 
			String[] columnNames = {
					"Hiker Name", "Location", "Country", "Time"
			};
			//creates the data array which serves as a list of names, locations, countries, and
			//time traveled for each hiker, with placeholder, like "Name 1, Location 1..." being set
			//until data is provided.
			Object[][] data = {
					{"Hiker Name", "Location", "Country", "Time"},
					{"Name 1", "Location 1", "Country 1", "Travel Time"},
					{"Name 2", "Location 2", "Country 2", "Travel Time"},
					{"Name 3", "Location 3", "Country 3", "Travel Time"},
					{"Name 4", "Location 4", "Country 4", "Travel Time"},
					{"Name 5", "Location 5", "Country 5", "Travel Time"},
					{"Name 6", "Location 6", "Country 6", "Travel Time"},
					{"Name 7", "Location 7", "Country 7", "Travel Time"},
					{"Name 8", "Location 8", "Country 8", "Travel Time"},
					{"Name 9", "Location 9", "Country 9", "Travel Time"},
					{"Name 10", "Location 10", "Country 10", "Travel Time"},
					{"Name 11", "Location 11", "Country 11", "Travel Time"},
					{"Name 12", "Location 12", "Country 12", "Travel Time"},
					{"Name 13", "Location 13", "Country 13", "Travel Time"},
					{"Name 14", "Location 14", "Country 14", "Travel Time"},
					{"Name 15", "Location 15", "Country 15", "Travel Time"},
					{"Name 16", "Location 16", "Country 16", "Travel Time"},
					{"Name 17", "Location 17", "Country 17", "Travel Time"},
					{"Name 18", "Location 18", "Country 18", "Travel Time"},
					{"Name 19", "Location 19", "Country 19", "Travel Time"},
					{"Name 20", "Location 20", "Country 20", "Travel Time"},
					{"Name 21", "Location 21", "Country 21", "Travel Time"},
					{"Name 22", "Location 22", "Country 22", "Travel Time"},
					{"Name 23", "Location 23", "Country 23", "Travel Time"},
					{"Name 24", "Location 24", "Country 24", "Travel Time"},
					{"Name 25", "Location 25", "Country 25", "Travel Time"},
					{"Name 26", "Location 26", "Country 26", "Travel Time"},
					{"Name 27", "Location 27", "Country 27", "Travel Time"},
					
					
			};

			//A JTable of all the data being declared and initialized, then being added to the JLabel
			hikes = new JTable(data, columnNames);
			hikes.setLayout(new FlowLayout());
			hikes.setLocation(0,  list.getHeight() / 32);
			hikes.setSize( list.getWidth()  ,3* list.getHeight()/4);
			System.out.println( Arrays.toString(columnNames));
			list.add(hikes);		
			add(list);
			
			
		
		}
	}
}