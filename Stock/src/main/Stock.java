package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Stock extends JLabel{
	
	//JLabels are created to show the name, price, change in value by percent, and how much you own of this stock,
	//with two other objects, a Graph object and OrderLabel object, are created to show you a graph of the change
	//in value of the stock and to show you that you ordered a certain amount of a stock
	private JLabel nameLabel;
	private JLabel priceLabel;
	private JLabel percentLabel;
	private Graph graphLabel;
	private JLabel ownLabel;
	private OrderLabel orderLabel;
	
	//a float is made that is the percent change in the stock's value, and ArrayList is made to hold all these changes
	//two more floats are made that are the minimum and maximum change in the stocks value, then there is an integer
	//that stores how much you own and a string that stores the name of the buyer
	private float percentChange;
	private ArrayList<Float> values;
	private final float min;
	private final float max;
	private int own;
	private final String buyerName;
	
	//constructor for the Stock class
	public Stock(int width, int height, String name, String buyerName, float cost, float min, float max, int x, int y) {
		//calls onto the super class (JLabel)
		super();
		//initializes the JLabel created by the super class, giving it the size and position specified in the parameters
		setSize(width, height);
		setLocation(x, y);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		//initializes the minimum and maximum floats and the string of the buyer's name with values from the 
		//parameters
		this.min = min;
		this.max = max;
		this.buyerName = buyerName;
		
		//the various JLabels from before are initialized, each with its own purpose to the user, serving
		//as various forms of info, with the OrderLabel and Graph objects also being initialized, and 
		//following the same purpose as info for the user about this fake stock market
		nameLabel = new JLabel(name, JLabel.CENTER);
		nameLabel.setBounds(width/3, height/2, 2*width/3, height/2);
		nameLabel.setFont(new Font(getFont().getName(), Font.PLAIN,height / 12));
		nameLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		nameLabel.setForeground(Color.BLACK);
		add(nameLabel);
		
		priceLabel = new JLabel(cost+"", JLabel.CENTER);
		priceLabel.setBounds(0, 2*height/3, width/3, height/3);
		priceLabel.setFont(new Font(getFont().getName(), Font.PLAIN,height / 12));
		priceLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		priceLabel.setForeground(Color.BLACK);
		add(priceLabel);
		
		percentLabel = new JLabel("0%", JLabel.CENTER);
		percentLabel.setBounds(0, height/2, width/3, height/6);
		percentLabel.setFont(new Font(getFont().getName(), Font.PLAIN,height / 12));
		percentLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		percentLabel.setForeground(Color.BLACK);
		add(percentLabel);
		
		ownLabel = new JLabel("0", JLabel.CENTER);
		ownLabel.setBounds(width/3, 0, 4*width/9, height/2);
		ownLabel.setFont(new Font(getFont().getName(), Font.PLAIN,height / 6));
		ownLabel.setBorder(BorderFactory.createLineBorder(Color.WHITE,5));
		ownLabel.setForeground(Color.BLACK);
		add(ownLabel);
		
		graphLabel = new Graph(new Rectangle(0, 0, width/3, height/2));
		add(graphLabel);
		
		orderLabel = new OrderLabel(new Rectangle(7*width/9, 0, 2*width/9, height/2));
		add(orderLabel);
						
	}
	
	//This method serves to update the stock market, by determining a new value for the stock in question using 
	//a formula that gives a value that is dependent on prior values
	public void update() {
		//graphLabel.update();
		
		percentChange = (values.get(values.size() - 1) - values.get(values.size() - 2)) / (values.get(values.size() - 2));
		
		//changes the JLabel in respect to the new change in the stock's value
		percentLabel.setText(percentChange+"%");
		percentLabel.setForeground(new Color(percentChange < -0.10 ? 255 : percentChange < -0.05 ? 100 : percentChange < 0 ? 50 : 0,
                percentChange > 0.10 ? 255 : percentChange > 0.05 ? 100 : percentChange > 0 ? 50 : 0, 
                        0));
		
		priceLabel.setText(values.get(values.size() - 1) + "");
		
	}
	
	
	private class OrderLabel extends JPanel{
		
		//A JSpinner is created to allow the user to input how much of a certain stock they would like to buy or sell, 
		//with two JButtons being created to allow them to either buy or sell
		private JSpinner amount;
		private JButton order;
		private JButton sell;
		
		//the OrderLabel class constructor
		public OrderLabel(Rectangle bounds) {
			//calls on the super class (JPanel)
			super();
			//sets the bounds of the JPanel using a Rectangle object provided in the parameters
			setBounds(bounds);
			
			//initializes the JSpinner, making it so the user can set the amount of stock they would like
			//to buy or sell, but not allowing them to go to negative values
			amount = new JSpinner();
			amount.setBounds(0, 0, bounds.width, bounds.height/3);
			amount.addChangeListener(new ChangeListener() {
				
				public void stateChanged(ChangeEvent arg0) {
					if((Integer)amount.getValue() < 0) {
						amount.setValue(0);
					}
					
				}
			});
			add(amount);
			
			//initializes the two JButtons, with the first adding more stock to the buyer's profile if
			//they have enough money to buy it and if they amount they wish to buy isn't a negative
			//amount, and if so the buyer is given the stock while losing money that they used
			//to get it (cont. below)
			order = new JButton("Buy!");
			order.setBounds(0, bounds.height/3, bounds.width, bounds.height/3);
			order.setOpaque(true);
			order.setBackground(Color.WHITE);
			order.setForeground(Color.GREEN);
			order.setFont(new Font(getFont().getName(), Font.PLAIN, bounds.height / 10));
			order.setFocusable(false);
			order.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					int x = (Integer) amount.getValue();
					if(x > 0 && Main.gui.game.getMoney(buyerName) - x * values.get(values.size()-1) >= 0) {
						Main.gui.game.addOrder(nameLabel.getText(), buyerName, x, x * values.get(values.size()-1));
						Main.gui.game.setMoney(buyerName, Main.gui.game.getMoney(buyerName) - x * values.get(values.size()-1)  );
						own += x;
						ownLabel.setText(own + "");

						
					}
				}
			});
			
			//the second JButton is similar to the first, but since it is meant for selling stock
			//its functionality will be different, with it checking if the user isn't selling
			//negative stock (stock that doesn't exist) and if the amount of stock that is 
			//being sold isn't greater than the amount the user has, and if these are true,
			//the user's stock is taken away but they are paid whatever the price was 
			//for those stock at the time
			sell = new JButton("Sell!");
			sell.setBounds(0, 2*bounds.height/3, bounds.width, bounds.height/3);
			sell.setOpaque(true);
			sell.setBackground(Color.WHITE);
			sell.setForeground(Color.RED);
			sell.setFont(new Font(getFont().getName(), Font.PLAIN, bounds.height / 10));
			sell.setFocusable(false);
			sell.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					int x = -(Integer) amount.getValue();
					if(x < 0 && own + x >= 0) {
						Main.gui.game.addOrder(nameLabel.getText(), buyerName, x, x * values.get(values.size()-1));
						Main.gui.game.setMoney(buyerName, Main.gui.game.getMoney(buyerName) - x * values.get(values.size()-1)  );
						own += x;
						ownLabel.setText(own + "");
					}
				}
			});
			add(order);
			add(sell);
			
		}
	}
	
	
	
	
	private class Graph extends JPanel{
		//two integers that represent the height and width of the graph of the stock's price change
		//in percentage
		private final int width;
		private final int height;
		
		//this timer is used to update the stock's price value in a constant time interval, with the
		//actual change in the stock's value being completely random
		private Timer timer = new Timer(350, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				values.add((int)Math.round((float)(Math.random() * (max - min)) * 100) / 100.0f);
				priceLabel.setText(values.get(values.size()-1)+"");
				repaint();
			}
		});

		
		public Graph(Rectangle bounds) {
			//super class (JPanel) is called
			super();
			//uses bounds given in parameters for the JPanel and to give
			//values to the width and height integers from earlier
			setBounds(bounds);
			width = bounds.width;
			height = bounds.height;
			setBackground(new Color(50, 50, 50));
			setOpaque(true);
			
			//initializes the values array and starts the timer, beginning the changes in the
			//stock's value
			values = new ArrayList<Float>();
			values.add(50.00f);
			timer.start();
		}
		
		//public void update() {
			
		//}

		//paintComponent method which serves to constantly update the image of the graph 
		//whenever a new value is given to a stock by plotting that point on the graph, 
		//determining if the value is worse (red) or better (green), and drawing a 
		//line from the previous value to the new one
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

