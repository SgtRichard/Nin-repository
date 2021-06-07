package main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Gui extends JFrame {

	//width and height integers are declared, so are MainMenu and Game objects
	private final int width;
	private final int height;
	private MainMenu menu;
	public Game game;

	
	public Gui() {
		//super class is called (JFrame)
		super("Stock Broker Game Thingy Simulator yes");
		//super class JFrame is initialized
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,screen.width,screen.height);
        setLayout(null);
        setResizable(false);
        
        this.setVisible(true);
        //height and width integers are given values
        width = getWidth() - getInsets().left - getInsets().right;
        height = getHeight() - getInsets().top - getInsets().bottom;
        this.setVisible(false);
		
        //MainMenu and Game objects are both initialized
		menu = new MainMenu();
		game = new Game();
		add(menu);
		setVisible(true);
		
		
		
	}

	private class MainMenu extends JPanel {

		//minimum and maximum floats are created, along with a timer
		//and an array that contains more floats, with all of these
		//variables being initialized instantly 
		private final float min = 0.00f;
		private final float max = 100.00f;
		private ArrayList<Float> values = new ArrayList<Float>();
		private Timer timer = new Timer(350, new ActionListener() {
			
			//randomly adds variables to the values array which are somewhat
			//dependent on the minimum and maximum values
			public void actionPerformed(ActionEvent e) {
				values.add((float) (Math.random() * (max - min)));
				repaint();
			}
		});

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int j = values.size() >= 20 ? values.size() - 20 : 0;
			int[] x = new int[j == 0 ? values.size() : 20];
			int[] y = new int[j == 0 ? values.size() : 20];
			for (int i = 0; i < x.length; i++) {
				x[i] = i * width / (20);
				y[i] = (int) (height - height * (values.get(j + i) - min) / (max - min));
			}
			for (int i = 0; i < y.length - 1; i++) {
				g.setColor(y[i + 1] < y[i] ? Color.GREEN : Color.RED);
				g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
			}

		}
		
		//a play and exit JButton are declared
		private JButton play;
		private JButton exit;

		//the MainMenu class constructor
		public MainMenu() {
			//calls on the super class (JPanel) and initializes it
			super();
			values.add(50.00f);
			setSize(width, height);
			setLayout(null);
			setBackground(new Color(50, 50, 50));
			
			//initializes the two JButtons from before, making one to bring the player into
			//the actual game, by removing the current "game state" and adding the one 
			//with the main game on it, and the other JButton is just meant to exit the game
			play = new JButton("Play");
			play.setSize(width / 3, 2 * height / 9);
			play.setLocation(width / 3, 2 * height / 9);
			play.setOpaque(true);
			play.setFocusable(false);
			play.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			play.setIcon(new ImageIcon(""));
			play.setFont(new Font(getFont().getName(), Font.BOLD, height / 7));
			play.setBackground(Color.WHITE);
			play.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					Main.gui.getContentPane().removeAll();
					Main.gui.add(game);
					Main.gui.repaint();
				}
			});
			
			add(play);

			exit = new JButton("Exit");
			exit.setSize(width / 3, 2 * height / 9);
			exit.setLocation(width / 3, 5 * height / 9);
			exit.setOpaque(true);
			exit.setFocusable(false);
			exit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
			exit.setIcon(new ImageIcon(""));
			exit.setFont(new Font(getFont().getName(), Font.BOLD, height / 7));
			exit.setBackground(Color.WHITE);
			exit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
					
				}
			});
			
			add(exit);

			setVisible(true);
			timer.start();
		}
	}

	
	
	
	public class Game extends JPanel {

		//two JLabels are made, intended to be a background and a display of the buyer's money amount,
		//with the amount of money the buyer has being tracked by a float. There are also three other
		//objects made, a Portfolio object, an OrderBox object, and a Trend object, all of which are
		//objects of sub classes.
		private JLabel background;
		private JLabel money;
		private float cash;
		private Portfolio portfolio;
		private OrderBox orderbox;
		private Trend trend;

		public Game() {
			//calls on the super class (JPanel) constructor and 
			//initializes the JPanel
			super();
			setSize(width, height);
			setLayout(null);
			
			//initializes the background JLabel and money amount JLabel, using the "cash" float
			//to know how much money the buyer has
			background = new JLabel();
			background.setSize(width, height);
			background.setLayout(null);
			background.setBackground(Color.BLACK);
			background.setOpaque(true);

			money = new JLabel();
			// money.setSize(d);
			money.setText("$$" + cash + "$$");
			// money.setLocation(topright);

			background.add(money);
			
			//the three objects from the subclasses are all initialized and added to the background
			portfolio = new Portfolio(new Rectangle( width/3 , height/12, width/3, 5*height/6));
			orderbox = new OrderBox(new Rectangle (11*width/15, height/12 , width/5, 5*height/6));
			trend = new Trend(new Rectangle(width/15, height/12 , width/5, 5*height/6));
			
			background.add(trend);
			background.add(orderbox);
			background.add(portfolio);
			add(background);
			
			
		}
		
		//getter and setter methods for the money amount of a certain buyer
		public float getMoney(String name) {
			return portfolio.getMoney(name);
		}
		
		public void setMoney(String name, float cash) {
			portfolio.setMoney(name, cash);
		}

		//a method which adds an order for a specific amount of stock for a certain buyer
		public void addOrder(String name, String buyerName, int amount, float totalCost) {
			orderbox.addOrder(name, buyerName, amount, totalCost);;
			
		}
		
		
		private class Portfolio extends JTabbedPane {
			
			//an array of Buyer objects is declared
			private Buyer[] buyers;
			
			public Portfolio(Rectangle bounds) {
				//calls on the super class constructor (JTabbedPane)
				//and initializes it
				super(JTabbedPane.TOP);
				setBounds(bounds);
			
			
				//sets a concrete amount of buyers, could be changed at any moment but for
				//now the game has 3 buyers, each with their own money amounts and stocks
				buyers = new Buyer[3];
				for(int i = 0; i < buyers.length; i++) {
					buyers[i] = new Buyer(bounds.width, bounds.height, "Buyer " + (i + 1));
					add("Buyer " + (i + 1), buyers[i]);
				}
				repaint();
			}
			
			//returns the amount of a money that a certain buyer has, returns 0 if the buyer
			//the user wants to look for doesn't exist
			public float getMoney(String buyer) {
				for(int j = 0; j < buyers.length; j++) {
					if (buyers[j].getName().equals(buyer) ) {
						return buyers[j].getCash();
					}
				}
				return 0;
			}
			
			//sets the amount of a money for a certain buyer
			public void setMoney(String buyer, float cash) {
				for(int i = 0; i < buyers.length; i++) {
					if(buyers[i].getName().equals(buyer)) {
						buyers[i].setCash(cash);
					}
				}
			}
		}

		
		
		
		private class OrderBox extends JPanel {
			
			//two JComboBoxes are created, one to have a list of buyer names,
			//and another to have a list of stock names, while a ViewPane is also
			//created to bring the two JComboBoxes together
			private JComboBox<String> buyer;
			private JComboBox<String> stock;
			private ViewPane view;
			
			public OrderBox(Rectangle bounds) {
				//super class is called (JPanel) and the JPanel is initialized
				super();
				setBounds(bounds);
				setLayout(null);
				
				//the two JComboBoxes are initialized, with the first adding all the buyer names to a list, 
				//and making it so if something were to change, to reset the names, with the same being done
				//to the second JComboBox, yet this time it is with the names of various stocks
				buyer = new JComboBox<String>(new String[] {"All","Buyer 1", "Buyer 2", "Buyer 3"});
				buyer.setBounds(bounds.width/16, bounds.height/20, 7*bounds.width/16, bounds.height/25);
				buyer.addItemListener(new ItemListener() {
					
					public void itemStateChanged(ItemEvent arg0) {
						if(arg0.getStateChange() == ItemEvent.SELECTED) {
							view.buyer = (String) buyer.getSelectedItem();
							view.reset();
						}
						
					}
				});
				
				
				
				
				
				stock = new JComboBox<String>();
				stock.addItem("All");
				for(int i = 0; i < Buyer.NAMES.length; i++) {
					stock.addItem(Buyer.NAMES[i]);
				}
				stock.setBounds(bounds.width/2, bounds.height/20, 7*bounds.width/16, bounds.height/25);
				stock.addItemListener(new ItemListener() {
					
					public void itemStateChanged(ItemEvent arg0) {
						if(arg0.getStateChange() == ItemEvent.SELECTED) {
							view.stock = (String) stock.getSelectedItem();
							view.reset();
						}
						
					}
				});
				
				
				
				view = new ViewPane(new Rectangle(bounds.width/16, 9*bounds.height/100, 7*bounds.width/8, 19*bounds.height/25));
				
				add(buyer);
				add(stock);
				add(view);
			}
			
			//this method adds orders to the ViewPane object for the user to see the orders they have
			public void addOrder(String name, String buyerName, int amount, float totalCost) {
				view.addOrder(name, buyerName, amount, totalCost);
			}
			
			private class ViewPane extends JPanel{
				
				//integers are created for height and width, while strings are created for
				//the buyer name and stock name, but are filled with placeholder names, 
				//with, lastly, an Order's object array list being declared.
				private ArrayList<Order> orders;
				private final int width;
				private final int height;
				private String buyer = "All";
				private String stock = "All";
				
				
				public ViewPane(Rectangle bounds) {
					//super class constructor is called (JPanel) with the
					//created JPanel being given dimensions
					super();
					//the Order objects arraylist is initialized, and so are the two integers
					//from before
					orders = new ArrayList<Order>();
					setBounds(bounds);
					width = bounds.width;
					height = bounds.height;
				}
				
				//adds an order to the list of orders, and if that order is one that is possible,
				//meaning that the name of the buyer and stock exists, it is displayed onto the screen
				public void addOrder(String name, String buyerName, int amount, float totalCost) {
					orders.add(new Order(width, height, name, buyerName, amount, totalCost));
					if(checkIfList(orders.get(orders.size()-1), buyer, stock)) {
						add(orders.get(orders.size()-1));
					}
				}
				
				
				//checks if the buyer's name and the stock's name of an order is either equal "all" or an
				//actual buyer or stock name, meaning that it exists
				public boolean checkIfList(Order order, String buyer, String stock) {
					return (buyer.equals("All") ? true : order.buyername.getText().equals(buyer)) && (stock.equals("All") ? true : order.stockname.getText().equals(stock));   
				}
				
				//refreshes the current display of orders
				public void reset(){
					removeAll();
					for(int i = 0; i < orders.size(); i++) {
						if(checkIfList(orders.get(orders.size()-1), buyer, stock)) {
							add(orders.get(orders.size()-1));
						}
					}
				}
				
				private class Order extends JPanel{
					
					//four JLabels are made to describe the buyer and stock
					private JLabel buyername;
					private JLabel stockcost;
					private JLabel stockname;
					private JLabel stockamount;
					
					public Order(int width, int height, String name, String buyerName, int amount, float totalCost) {
						//super class (JPanel) is called, declaring and then initializing said JPanel
						super();
						setSize(width, height/10);
						setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
						setLayout(null);
						
						//various JLabels that have descriptions of a stock and a buyer are initialized
						stockname = new JLabel(name, JLabel.CENTER);
						stockname.setBounds(0,0, 5*width/6, height/2);
						add(stockname);
						
						stockcost = new JLabel(totalCost+"", JLabel.CENTER);
						stockcost.setBounds(width/2, height/2, width/2, height/2);
						add(stockcost);
						
						buyername = new JLabel(buyerName, JLabel.CENTER);
						buyername.setBounds(0, height/2, width/2, height/2);
						add(buyername);
						
						stockamount = new JLabel(amount+"", JLabel.CENTER);
						stockamount.setBounds(5*width/6, 0, width/6, height/2);
						add(stockamount);
						setVisible(true);
						
					}
				}
			}
		}

		
		
		
		private class Trend extends JPanel {
			
			//integers are created for width and height, floats are created
			//to represent the maximum and minimum values, of the trend, 
			//with an arraylist of floats being created to keep track of the
			//trend and a timer being made to determine how often this
			//trend should take an effect on the market
			private final int width;
			private final int height;
			private final float min = 0.00f;
			private final float max = 100.00f;
			private ArrayList<Float> values;
			private Timer timer = new Timer(500, new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					values.add((float) (Math.random() * (max - min)));
					repaint();
				}
			});

			public Trend(Rectangle bounds) {
				//JPanel super class constructor is called, later initialized with
				//bounds given from the parameter. The height and width integers
				//are initialized, and so is the values array/
				super();
				setBounds(bounds);
				width = bounds.width;
				height = bounds.height;
				setBackground(new Color(50, 50, 50));
				setOpaque(true);
				values = new ArrayList<Float>();
				values.add(50.00f);
			
				
				timer.start();
			}

			//changes the graph displaying price changes by percentage by whatever
			//"trend" is happening in the market, which is random but somewhat 
			//depenedent on the minimum and maximum values from earlier
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				int j = values.size() >= 20 ? values.size() - 20 : 0;
				int[] x = new int[j == 0 ? values.size() : 20];
				int[] y = new int[j == 0 ? values.size() : 20];
				for (int i = 0; i < x.length; i++) {
					x[i] = i * width / (20);
					y[i] = (int) (height - height * (values.get(j + i) - min) / (max - min));
				}
				for (int i = 0; i < y.length - 1; i++) {
					g.setColor(y[i + 1] < y[i] ? Color.GREEN : Color.RED);
					g.drawLine(x[i], y[i], x[i + 1], y[i + 1]);

				}

			}
		}
	}
}
