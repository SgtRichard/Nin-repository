package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Buyer extends JPanel {
	
	//JLabels are created for the background and to display the amount of money the buyer has
	private JLabel money;
	private JLabel background; 
	//a stocks array is made with only 6 slots
	private Stock[] stocks = new Stock[6];
	//default starting cash for each buyer
	private float cash = 10000.00f;
	
	//various arrays are made, one being the costs of the stocks, another being the names, another being the maximum 
	//and minimum value for each stock, and lastly is the position of each stock on the user's display in terms
	//of x and y coordinates
	private final float[] COSTS;
	public static final String[] NAMES = {"Google", "Universal Bakery", "Terra", "Rico Corp", "Felipe Industries", "Standard Oil", "Shell", "Nin Real Estate", "Comp Sci Gang", "Baking USA", "Paint 3D", "Berkshire Hathaway", "Trump Tower", "Derlio", "Eclipse", "POTW INC", "SNP 500", "PlayBoy", "Chinese Children", "Make a Wish fnd"};
	private static final float[] MAXS = {500.00f, 		300.00f, 			250.00f, 275.00f,   325.00f,              550.00f,       475.00f, 225.00f, 			425.00f, 		300.00f, 	   750.00f, 	350.00f, 			700.00f, 		1000.00f, 350.00f, 	100.00f, 	501.00f, 	800.00f, 	1500.00f, 			325.00f   };
	private static final float[] MINS = {100.00f, 		50.00f,  			40.00f,  125.00f,   20.00f,               125.00f,       150.00f, 75.00f,  			125.00f, 		75.00f,   	   250.00f, 	150.00f, 			300.00f, 		500.00f,  55.00f,  	25.00f,  	105.00f, 	200.0f,  	300.00f,  			225.00f};
	private final int[] X;
	private final int[] Y;
	//an array to store random indexes that are to be used in other arrays, which is declared alongside a 
	//string that holds the buyer's name
	private final int[] indexes;
	private final String name;
	
	public Buyer(int width, int height, String name ) {
		//super class constructor is called upon (JPanel) and 
		//is quickly initialized
		super();
		setSize(width, height);
		setLayout(null);
		//the x and y coordinate arrays are initialized as to where each stock 
		//shall be on the user's display
		X = new int[] {width/15,  8*width/15, width/15, 8*width/15, width/15, 8*width/15};
		Y = new int[] {height/16, height/16, 3*height/8, 3*height/8, 11*height/16, 11*height/16};
		
		//the costs array is initialized with the initial value of each stock, which is completely
		//dependent on what the maximum and minimum value for said stock is
		COSTS = new float[NAMES.length];
		this.name = name;
		for(int i = 0; i < NAMES.length; i++) {
			COSTS[i] = (MAXS[i] + MINS[i])/2;
		}
		
		//background and money JLabels are initialized
		background = new JLabel();
		background.setOpaque(true);
		background.setBackground(Color.GRAY);
		background.setSize(width, height);
		background.setLayout(null);

		
		money = new JLabel();
		money.setSize(width/2, height/30);
		money.setText(cash +"$$$$$");
		money.setLocation(width/15, 0);
		money.setFont(new Font(getFont().getName(), Font.PLAIN, height / 30));
		money.setForeground(Color.GREEN);
		background.add(money);
		
		//indexes array is initialized, guaranteed to have differing values per index
		indexes = new int[6];
		for(int i = 0; i < indexes.length; i++) {
			indexes[i] = (int) (20*Math.random());
			boolean b = true;
			for(int j = 0; j < i; j++) {
				if(indexes[j] == indexes[i]) {
					b = false;
				}
			}
			if(!b) {
				i--;
			}
		}
		
		
		//gives a random cost, minimum, maximum, and name to every stock in the stocks array
		for(int i = 0; i < indexes.length; i++) {
			float cost = COSTS[indexes[i]];
			String n = NAMES[indexes[i]];
			float min = MINS[indexes[i]];
			float max = MAXS[indexes[i]];
			stocks[i] = new Stock(2*width/5, height/4, n,this.name, cost, min, max, X[i], Y[i]) ;
			background.add(stocks[i]);
			
			
		}
		
		timer.start();
		add(background);
	}
	//gets the buyer's cash amount
	public float getCash() {
		return cash;
	}
	//gets the buyer's name
	public String getName() {
		return name;
	}
	
	//sets the buyer's cash to a new amount
	public void setCash(float newcash) {
		cash = newcash;
	}
	
	//updates the values of each stock in the stocks array
	public void update() {
		for(int i = 0; i < stocks.length; i++) {
			stocks[i].update();
		}
	}
	//timer that constantly displays the buyer's current money amount
	private Timer timer = new Timer(5, new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			money.setText(cash+"");
		}
	});

	
	
}
