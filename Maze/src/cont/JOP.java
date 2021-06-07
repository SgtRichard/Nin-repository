package cont;

import javax.swing.JOptionPane;

public class JOP {
	public JOP() {}
	
	public static String _Lv="";
	
	//a method which asks the user which level they will play, and then asks what move they will do, 
	//returning the answer as a string
	public static String Level() 
	{
		while (!(_Lv.equalsIgnoreCase("1")) && !(_Lv.equalsIgnoreCase("2"))&& !(_Lv.equalsIgnoreCase("3")))
		{_Lv = JOptionPane.showInputDialog("What level will you start at \n 1 easiest \n 2 medium \n 3 hardest");}
		msg("A quick reminder that Typing in a level Number as your move sends you to that level");
		return _Lv;
	}
	
	//getting for Lv, the player's response
	public static String getLv() {return _Lv;}
	
	//method which hastens the process of delivering JOptionPane messages
	public static void msg(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	//method which hastens the process of asking for input via JOptionPane messages
	public static String in(String msg){
		return JOptionPane.showInputDialog(msg);
	}
}

