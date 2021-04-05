import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.GregorianCalendar;

class IOSettings {
  /**
  *@Author Maximilian C. Sutton
  *@Version 0.10
  *@Since 2021-04-01
  */

  public static File settings = new File("Setting.dat");  
  public static File defSettings = new File("DefSetting.dat");

  public static void addsSet() throws FileNotFoundException {    
    //adds on the new settings
    PrintWriter out = new PrintWriter(settings);
    out.println("\nName:");
    out.close();
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
}