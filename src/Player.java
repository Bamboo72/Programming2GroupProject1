public class player{

    	/**
    	*@Author Maximilian C. Sutton
    	*@Version 0.01
    	*@Since 2020-12-09
    	*/

	String name = " ";
	int playerNum = 0;
	int playersXPos = 0;
	int playersYPos = 0;
	String dirFace = " ";
	static String[] inventory = new String[100];


	/**
	* The constructor for a resource object
	*/
	static public void clearInventory() {
		for(int i = 0; i < 100; i++) {
			//first fill with empty str
			inventory[i] = " ";
		}
	}


	/**
	* a function that moves a player
	* @param x
	* @param y
	*/
	static public void move(int x, int y){

	}

	/**
	* a function that colects recorces 
	* @param x
	* @param y
	* @param dirFace
	*/
	static public void gather(int x, int y, String dirFace){
		
	}


	/**
	* a function that builds buildings 
	* @param x
	* @param y
	* @param type
	* @param dirFace
	*/
	static public void build (int x, int y, String type, String dirFace){

	}
}