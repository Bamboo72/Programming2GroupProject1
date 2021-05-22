import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IOSettings {
  /**
  *@Author Maximilian C. Sutton
  *@Version 1.00
  *@Since 2021-04-13
  */

  //file varables
  public static File settings = new File("Setting.dat");  
  public static File defSettings = new File("DefSetting.dat");

  /**
  * wrights to the file
  * @param String diceColor, spawnRate
  * @param boolean naturalDis
  */
  public static void addsSet(String diceColor, String spawnRate, boolean naturalDis) throws FileNotFoundException {
    if(diceColor == "" || spawnRate == ""){
      System.out.println("Error: peram not passed in");
    } else {
      PrintWriter out = new PrintWriter(settings);
      out.println("\n" + diceColor + "\n\n" + spawnRate + "\n\nnaturalDis" + naturalDis);
      out.close();
    }
  }

  /**
  * reads from a default settings file to the settings file
  */
  public static void restor() throws FileNotFoundException {
    String oldSpice = "";
    Scanner in = new Scanner(defSettings);
    while(in.hasNextLine()){
      oldSpice = oldSpice + in.nextLine() + "\n";
    }
    in.close();

    PrintWriter out = new PrintWriter(settings);
    out.println(oldSpice);
    out.close();
  }

  /**
  * reads the type of dice and passes it back
  * @returns String die
  */
  public static String findDie() throws FileNotFoundException {
    Scanner inD = new Scanner(settings);
    String die = inD.nextLine();
    die = inD.nextLine();
    return die;
  }
  
  /**
  * reads from the file the spawn rate
  * @returns String spawn
  */
  public static String findSpawnRate() throws FileNotFoundException {
    Scanner inS = new Scanner(settings);
    String spawn = inS.nextLine();
    for(int i = 0; i < 3; i++){
      spawn = inS.nextLine();
    }
    return spawn;
  }

  /**
  * reads from the file if natural disaters are on
  * @returns String natDis
  */
  public static String findNaturalDis() throws FileNotFoundException {
    Scanner inS = new Scanner(settings);
    String natDis = inS.nextLine();
    for(int i = 0; i < 5; i++){
      natDis = inS.nextLine();
    }
    return natDis;
  }
}
