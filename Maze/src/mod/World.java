package mod;

import cont.JOP;
import view.StringMap;

public class World {

	//various objects are created, including a Player object, a Minotaur object, a Harpy object,
	//a Cyclops object, a Maze object, a StringMap object, and a JOP object, with two integers,
	//a string, and a boolean also being declared
	private static Player _p;
	private static Cyclops _c;
	private static Harpy _h;
	private static Minotaur _t;
	private static Maze _m;
	private static StringMap _s;
	@SuppressWarnings("unused")
	private JOP _jop;
	static int i;
	static int steps;
	static String step;

	static boolean mapChange;

	//class constructor, immediately runs the run method with the parameter
	public World(String s) {
		run(s);
	}
	public static int run(String s)
	{
		steps = 0;
		mapChange = false;
		//determining which map to load depending on user input
		if(s.equalsIgnoreCase("1")) //Loads map 1
		{
			_m = new Maze();
			_p = new Player(_m.getPlyStart()[0], _m.getPlyStart()[1], false);
			_t = new Minotaur(_m.getMinStart()[0], _m.getMinStart()[1]);
			_c = new Cyclops(0, 0, false);
			_h = new Harpy(0, 0, false);
		}
		if(s.equalsIgnoreCase("2"))//Loads map 2
		{
			_m = new Maze();
			_p = new Player(_m.getPlyStart()[0], _m.getPlyStart()[1], false);
			_t = new Minotaur(_m.getMinStart()[2], _m.getMinStart()[3]);
			_c = new Cyclops(_m.getCycStart()[0], _m.getCycStart()[1], true);
			_h = new Harpy(0, 0, false);
		}
		if(s.equalsIgnoreCase("3"))// Loads map 3 
		{

			_m = new Maze();
			_p = new Player(_m.getPlyStart()[0], _m.getPlyStart()[1], true);
			_t = new Minotaur(_m.getMinStart()[4], _m.getMinStart()[5]);
			_c = new Cyclops(_m.getCycStart()[2], _m.getCycStart()[3], true);
			_h = new Harpy(_m.getHarStart()[0], _m.getHarStart()[1], true);
		}
		_s = new StringMap(_m, _p, _t,_c,_h);
		//convert the user's input to a string to see if they want to change maps
		//and do any changes if need be
		String str = JOP._Lv;
		 i = Integer.parseInt(str);
		update(i);
		if(mapChange) // Change Map
		{
			@SuppressWarnings("unused")
			World obj = new World(JOP._Lv);
			return 0;
		}
		return 0;
	}


	public static void update(int i) {
		boolean isPlaying = true;
		while (isPlaying) {
			_m.Lock(_t.isAlive(),_c.isAlive(),_h.isAlive(),_p.hasKey());
			boolean on = true;
			//generate a map depending on what the player has asked for, 1 for easy,
			//2 for medium, etc.
			String map = _s.generateMap(i);
			String msg = "WASD to move. What direction do you want to move?";

			while (on) 
			{
				//get the user's inputs
				String move = JOP.in(map + msg);

				//move the player using said inputs
				if(move == null) {

				}
				else if(move.equalsIgnoreCase("steps"))
				{
					step = "" + steps +"  " + steps%2;
					JOP.msg(step);
				}
				else if(move.equalsIgnoreCase("1") || move.equalsIgnoreCase("2") || move.equalsIgnoreCase("3"))
				{
					on = false;
					mapChange = true;
					isPlaying = false;
					JOP._Lv = move;
				}
				else if (getPlayerMove(move)) {
					on = false;
				}
			}
			steps++;
			_p.giveSword();
			_p.giveKey();
			//check for whether the player has won
			if (victory()) {
				isPlaying = false;
				if(i == 3)
				{
				JOP.msg("Freedoom! From the Labyrinth");
				}
				else {
					int sum = i +1;
					JOP._Lv = ""+ sum;
					mapChange =true;
				}
			}
			//move the Minotaur, the Cyclops (three times), and the Harpy
			moveMinotaur();
			moveCyclops();moveCyclops();moveCyclops();
			moveHarp();
			
			//check for any deaths
			if(death()) {
				isPlaying = false;
				JOP.msg("You are dead");
			}
		}
	
		
	}

	//This method determines where the player will move depending on the inputs that the user
	//has given
	private static boolean getPlayerMove(String s) {

		// Moving North
		if (s.equalsIgnoreCase("W")) {
			if ((_p.getRow() - 1) >= 0 && _m.getMaze(i)[_p.getRow() - 1][_p.getCol()]) {
				_p.setPos(_p.getRow() - 1, _p.getCol());
				
				return true;
			} else {
				return false;
			}
		}
		// Moving South
		if (s.equalsIgnoreCase("S")) {
			if ((_p.getRow() + 1) < _m.getMaze(i).length && _m.getMaze(i)[_p.getRow() + 1][_p.getCol()]) {
				_p.setPos(_p.getRow() + 1, _p.getCol());
				
				return true;
			} else {
				return false;
			}
		}
		// Moving East
		if (s.equalsIgnoreCase("D")) {
			if ((_p.getCol() + 1) < _m.getMaze(i)[0].length && _m.getMaze(i)[_p.getRow()][_p.getCol() + 1]) {
				_p.setPos(_p.getRow(), _p.getCol() + 1);

				return true;
			} else {
				return false;
			}
		}
		// Moving West
		if (s.equalsIgnoreCase("A")) {
			if ((_p.getCol() - 1) >= 0 && _m.getMaze(i)[_p.getRow()][_p.getCol() - 1]) {
				_p.setPos(_p.getRow(), _p.getCol() - 1);

				return true;
			} else {
				return false;
			}
		}

		return false;
	}
	
	//these three methods are identical apart from the object (player enemy) it is for, with it
	//being a method that uses the player's current position to determine that best route
	//to the player, with the enemy having to be alive to do so
	private static void moveMinotaur() {
		int rDist = _p.getRow() - _t.getRow();
		int cDist = _p.getCol() - _t.getCol();
		int r = _t.getRow();
		int c = _t.getCol();
		if(_t.isAlive()) {
		// Minotaur moving North
		if(rDist < 0 && _m.getMaze(i)[r - 1][c]) {
			_t.setPos(r - 1, c);
		}

		// Minotaur moving South.
		if(rDist > 0 && _m.getMaze(i)[r +1][c]) {
			_t.setPos(r + 1, c);
		}
		// Minotaur moving East
		if(cDist > 0 && _m.getMaze(i)[r][c + 1]) {
			_t.setPos(r, c + 1);
		}
		// Minotuar moving west
		if(cDist < 0 && _m.getMaze(i)[r][c - 1]) {
			_t.setPos(r, c - 1);
		}
		}
	}
	private static void moveCyclops() {
		int rDist = _p.getRow() - _c.getRow();
		int cDist = _p.getCol() - _c.getCol();
		int r = _c.getRow();
		int c = _c.getCol();
		if(_c.isAlive() &&  steps%2 == 0) {
		// cyclops moving North
		if(rDist < 0 && _m.getMaze(i)[r - 1][c]) {
			_c.setPos(r - 1, c);
		}

		// cyclops moving South.
		if(rDist > 0 && _m.getMaze(i)[r +1][c]) {
			_c.setPos(r + 1, c);
		}
		// cyclops moving East
		if(cDist > 0 && _m.getMaze(i)[r][c + 1]) {
			_c.setPos(r, c + 1);
		}
		// cyclops moving west
		if(cDist < 0 && _m.getMaze(i)[r][c - 1]) {
			_c.setPos(r, c - 1);
		}
		}
	}
	private static void moveHarp() {
		int rDist = _p.getRow() - _h.getRow();
		int cDist = _p.getCol() - _h.getCol();
		int r = _h.getRow();
		int c = _h.getCol();
		if(_h.isAlive()){
		// Harpy moving North
		if(rDist < 0 ) {
			_h.setPos(r - 1, c);
		}

		// Harpy moving South.
		if(rDist > 0 ) {
			_h.setPos(r + 1, c);
		}
		// Harpy moving East
		if(cDist > 0 ) {
			_h.setPos(r, c + 1);
		}
		// Harpyw moving west
		if(cDist < 0 ) {
			_h.setPos(r, c - 1);
		}
		}
	}
	
	//determines when the player or an enemy should die, for example if the player is on the
	//same position as an enemy, like a cyclops, it will first be determined if the player
	//has a sword, and if so the cyclops is killed, otherwise the player dies
	public static boolean death() {
		if(_t.getRow() == _p.getRow() &&
				_t.getCol() == _p.getCol() && _p.hasSword()) 
		{
			return true;
		}
		if (_t.getRow() == _p.getRow() &&
				_t.getCol() == _p.getCol() && !(_p.hasSword()))
		{
			_t.kill();
		}
		
		if(_c.getRow() == _p.getRow() &&
				_c.getCol() == _p.getCol() && _p.hasSword()) 
		{
			return true;
		}
		if (_c.getRow() == _p.getRow() &&
				_c.getCol() == _p.getCol() && !(_p.hasSword()))
		{
			_c.kill();
		}
		
		if(_h.getRow() == _p.getRow() &&
				_h.getCol() == _p.getCol() && _p.hasSword()) 
		{
			return true;
		}
		if (_h.getRow() == _p.getRow() &&
				_h.getCol() == _p.getCol() && !(_p.hasSword()))
		{
			_h.kill();
		}
		return false;
	}

	//a simple method that only returns true when the player reaches the exit,
	//meaning they have won
	public static boolean victory() {
		if (_p.getRow() == _m.getExit()[0] && _p.getCol() == _m.getExit()[1])
			{return true;}
		return false;
	}
	
	//getter method for the integer i
	public static int getI() {return i;};
}
