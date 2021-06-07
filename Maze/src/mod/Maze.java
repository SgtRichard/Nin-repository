package mod;

public class Maze {

	//three boolean maps are created that represent the maps that the player will traverse through, with true values being pathways and false
	//representing walls. Each map has increasing difficulty, with the maps increasing in size one after another.
	private boolean [][] _curMaze1 =
		{
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false}
		};
	private boolean [][] _curMaze2 =
		{
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false },
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},

		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false },
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false}
		};
	private boolean [][] _curMaze3 =
		{
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false, 	false, true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true,	true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true,	false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true,	false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	true, 	false,	false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	true, 	true, 	true,		true, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	true,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},

		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	true, 	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	true, 	true, 	true, 	true, 	true, 	true, 	true,	true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	true, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	true, 	false, 	true, 	false, 	true, true,	true, 	true, 	true, 	false, 	false, 	true, 	true, 	false, 	false, false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	false, 	true, 	true, 	true, 	false, 	false, true,	false, 	true, 	false, 	false, 	false, 	true, 	false, 	false, 	false,false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	false, 	true, 	true, 	false, 	false, 	true, 	false, 	false, true,	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false },
		
		{false,		false, 	true, 	false, 	true, 	false, 	false, 	false, 	false, 	false, false,	true, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false, 	false, true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true,	true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true,	false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true,	false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false,	false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, true,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false},

		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	true, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false},
		
		{false,		false, 	true, 	true, 	true, 	false, 	true, 	true, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	false, 	false},
		
		{false,		false, 	true, 	false, 	true, 	true, 	true, 	true, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false,	false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true,	true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true},
		
		{true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, true,		true, 	true, 	true, 	true, 	true, 	true, 	true, 	false, 	true, false,		false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	true, 	true, 	true, 	true},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,	false, 	true, 	false, 	false, 	false, 	false, 	true, 	true, 	true, false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,		false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false, false,	false, 	true, 	true, 	true, 	false, 	true, 	false, 	false, 	false},
		
		{false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false,false,		false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false, false,	false, 	true, 	false, 	true, 	true, 	true, 	false, 	false, 	false},
		
		{false,		false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,		false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false, false,	false, 	true, 	false, 	false, 	false, 	false, 	false, 	false, 	false }
		};
	
	// private int[][] _plyStartLocations;
	// private int[][] _minStartLocations;
	// private int[][] _exit;
	// private int[][] _sword;
	
	//arrays that declare the starting positions for the player, the minotaur, the cyclops, the harpy
	//the key, the exit, and the sword
	private int[] _plyStartLocations = {0,2};
	private int[] _minStartLocations = {5,9,13,15,33,37};
	private int[] _cycStartLocations = {5,17,14,21};
	private int[] _harStartLocations = {12,16};
	private int[] _key = {34,36};
	private int[] _exit = {5,0};
	private int[] _sword = {8,2,11,6,21,2};
	
	//a getter method for the current maze that the user is playing in.
	public boolean[][] getMaze(int i) 
	{ if(i==1) {return _curMaze1;} if(i==2) {return _curMaze2;}if(i==3) {return _curMaze3;}return _curMaze1;}
	
	//a method which checks whether or not a certain spot on each maze map is locked by checking if any of the
	//four parameter booleans are true
	public void Lock(boolean a,boolean b,boolean c, boolean d)
	{
		if(a || b || c || d) {_curMaze1[5][0] = false;_curMaze2[5][0] = false;_curMaze3[5][0] = false;}
		else {_curMaze1[5][0] = true;_curMaze2[5][0] = true;_curMaze3[5][0] = true;}
	}
	
	//getter methods for the player's and monster's starting positions, the exit, the sword, and the key
	public int[] getPlyStart() { return _plyStartLocations; }
	public int[] getCycStart() { return _cycStartLocations; }
	public int[] getMinStart() { return _minStartLocations; }
	public int[] getExit() { return _exit; }
	public int[] getSword() { return _sword; }
	public int[] getHarStart() {return _harStartLocations;}
	public int[] getKey() {return _key;}
	
}
