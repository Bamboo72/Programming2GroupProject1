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
	static String[] inventory = new String[100];

	static public void clearInventory() {
		for(int i = 0; i < 100; i++) {
			//first fill with empty str
			inventory[i] = " ";
		}
	}

	static public void move(int x, int y){

	}

	static public void gather(int x, int y){
		
	}

	static public void build (int x, int y, String type){

	}




	public static void main(String[] args) {
		
	}
}