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

  public static void addsSet(String diceColor, String spawnRate) throws FileNotFoundException {
    //if nothing is called by mistake
    if(diceColor == "" && spawnRate == ""){
      //fisrst make sure that something is passed in
    } else if(diceColor == ""){
      //adds the new spawn rate
      diceColor = empty("dc");
      PrintWriter out = new PrintWriter(settings);
      out.println("\n" + diceColor + "\n\n" + spawnRate);
      out.close();
    } else if(spawnRate == ""){
      //adds the new dice color
      spawnRate = empty("sr");
      PrintWriter out = new PrintWriter(settings);
      out.println("\n" + diceColor + "\n\n" + spawnRate);
      out.close();
    } else {
      //adds both the new die color, and spawn rate
      PrintWriter out = new PrintWriter(settings);
      out.println("\n" + diceColor + "\n\n" + spawnRate);
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

  public static String empty(String line) throws FileNotFoundException {
    Scanner inE = new Scanner(settings);
    String oldSpice = "";     
    if(line == "dc"){
      oldSpice = inE.nextLine();
      oldSpice = inE.nextLine();
    } else {
      oldSpice = inE.nextLine();
      oldSpice = inE.nextLine();
      oldSpice = inE.nextLine();
    }
    inE.close();
    return oldSpice;
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
    spawn = inS.nextLine();
    spawn = inS.nextLine();
    spawn = inS.nextLine();
    return spawn;
  }
}
