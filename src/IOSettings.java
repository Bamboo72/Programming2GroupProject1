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

  public static File settings = new File("Setting.dat");  
  public static File defSettings = new File("DefSetting.dat");

  public static void addsSet(String diceColor, String spawnRate, boolean naturalDis) throws FileNotFoundException {
    if(diceColor == "" || spawnRate == ""){
      System.out.println("Error: peram not passed in");
    } else {
      PrintWriter out = new PrintWriter(settings);
      out.println("\n" + diceColor + "\n\n" + spawnRate + "\n\nnaturalDis" + naturalDis);
      out.close();
    }
  }

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

  public static String findDie() throws FileNotFoundException {
    Scanner inD = new Scanner(settings);
    String die = inD.nextLine();
    die = inD.nextLine();
    return die;
  }
  
  public static String findSpawnRate() throws FileNotFoundException {
    Scanner inS = new Scanner(settings);
    String spawn = inS.nextLine();
    for(int i = 0; i < 3; i++){
      spawn = inS.nextLine();
    }
    return spawn;
  }

  public static String findNaturalDis() throws FileNotFoundException {
    Scanner inS = new Scanner(settings);
    String spawn = inS.nextLine();
    for(int i = 0; i < 5; i++){
      spawn = inS.nextLine();
    }
    return spawn;
  }
}