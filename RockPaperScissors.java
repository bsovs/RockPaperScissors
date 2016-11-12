//Java Rock-Paper-Scissors Game
//Created by Brandon Sovran

//Java Imports
import java.io.*;
import java.util.Random;
import java.util.Scanner;

//Main Class
public class RockPaperScissors {
  
    public static String winsStr = "";
    public static String lossesStr = "";
    public static String tiesStr = "";
    public static int lineNumber = 0;
    
    public static boolean playingRPS = false;
    public static int wins = 0;
    public static int losses = 0;
    public static int ties = 0;
    
    public static Scanner scan = new Scanner(System.in);
  
  public static void main(String arg[]) throws IOException, InterruptedException{ 
    
    File f = new File("Storage.txt");
    if(!f.exists() && !f.isDirectory()) { 
      PrintWriter printWriter = new PrintWriter("Storage.txt");
      printWriter.println (0);
      printWriter.println (0);
      printWriter.println (0);
      printWriter.close ();
    }
    
    boolean atCasino = true;
    
    while (atCasino == true) {
    
    winsStr = "";
    lossesStr = "";
    tiesStr = "";
    lineNumber = 0;
    
    playingRPS = false;
    wins = 0;
    losses = 0;
    ties = 0;
    
    //User Input
    System.out.println("What Game Would You Like to Play? (1)Rock-Paper-Scissors, (2)Coming-Soon ");
    System.out.print(">>>");
    int chooseGame = scan.nextInt();
    
    if (chooseGame==1) {
      playingRPS = true;
      System.out.println();
      RPS();
    }
    else if (chooseGame==2) {
      
    }
    else {}
    
    //User Input
    System.out.println();
    System.out.println("Keep Playing at Casino? (Y)es, (N)o.");
    System.out.print(">>>");
    String stayAtCasino = scan.next();
    stayAtCasino = stayAtCasino.toLowerCase();
    
    if (stayAtCasino.equals("y")) {
      atCasino = true;
      System.out.println();
    }
    else if (stayAtCasino.equals("n")) {
      atCasino = false;
      break;
    }
    else {
      atCasino = false;
      break;
    }
    
  }
    
  }
  
  public static void RPS() throws IOException, InterruptedException {
  
  while (playingRPS == true) {
    
    BufferedReader br = new BufferedReader(new FileReader("Storage.txt")); 
    String line;
    while ((line = br.readLine()) != null && lineNumber <= 2) {
       if (lineNumber==0) {
       winsStr = line;
       }
       else if (lineNumber==1) {
       lossesStr = line;
       }
       else if (lineNumber==2) {
       tiesStr = line;
       }
       else {
         System.out.println("Error...");
       }
       ++lineNumber;
     }
    
    
    int storedWins = Integer.parseInt(winsStr);
    int storedLosses = Integer.parseInt(lossesStr);
    int storedTies = Integer.parseInt(tiesStr);
    
    Random randomInt = new Random();
    int AIGuess = randomInt.nextInt(3) + 1;
    //1 is Rock, 2 is papper, 3 is scissors
    
    //String of Moves
    String UIGuessStr = "";
    String AIGuessStr = "";
    
    //User Input
    System.out.println("(R)ock, (P)aper, (S)cissors");
    System.out.print(">>>");
    String UIGuess = scan.next();
    UIGuess = UIGuess.toLowerCase();
    
    //Check Results
    if (UIGuess.equals("r")) {
      UIGuessStr = "Rock";
      if (AIGuess == 1) {
        ++ties;
        AIGuessStr = "Rock";
      }
      else if (AIGuess == 2) {
        AIGuessStr = "Paper";
        ++losses;
      }
      else if (AIGuess == 3) {
        AIGuessStr = "Scissors";
        ++wins;
      }
    }
    else if (UIGuess.equals("p")) {
      UIGuessStr = "Paper";
      if (AIGuess == 1) {
        AIGuessStr = "Rock";
        ++wins;
      }
      else if (AIGuess == 2) {
        AIGuessStr = "Paper";
        ++ties;
      }
      else if (AIGuess == 3) {
        AIGuessStr = "Scissors";
        ++losses;
      }
    }
    else if (UIGuess.equals("s")) {
      UIGuessStr = "Scissors";
      if (AIGuess == 1) {
        AIGuessStr = "Rock";
        ++losses;
      }
      else if (AIGuess == 2) {
        AIGuessStr = "Paper";
        ++wins;
      }
      else if (AIGuess == 3) {
        AIGuessStr = "Scissors";
        ++ties;
      }
    }
    
    //Show Results of Hand
    System.out.println(UIGuessStr + " vs. " + AIGuessStr);
    
    //Pause
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.println(".");
    Thread.sleep(1000);
    
    //Session Record
    System.out.println("Session Record:");
    System.out.println(wins + " Wins, " + losses + " Losses, " + ties + " Ties.");
    
    //Update Storage
    PrintWriter printWriter = new PrintWriter("Storage.txt");
    printWriter.println (wins + storedWins);
    printWriter.println (losses + storedLosses);
    printWriter.println (ties + storedTies);
    printWriter.close (); 
    
    int totalWins = wins + storedWins;
    int totalLosses = losses + storedLosses;
    int totalTies = ties + storedTies;    
    
    //All Time Record
    System.out.println();
    System.out.println("All Time Record:");
    System.out.println(totalWins + " Total Wins, " + totalLosses + " Total Losses, " + totalTies + " Total Ties.");
    
    //Pause
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.print(".");
    Thread.sleep(500);
    System.out.println(".");
    Thread.sleep(2000);
    
    //User Input
    System.out.println();
    System.out.println("Play Again? (Y)es, (N)o.");
    System.out.print(">>>");
    String PlayAgain = scan.next();
    PlayAgain = PlayAgain.toLowerCase();
    
    if (PlayAgain.equals("y")) {
      playingRPS = true;
      System.out.println();
    }
    else if (PlayAgain.equals("n")) {
      playingRPS = false;
      break;
    }
    else {
      playingRPS = false;
      break;
    }
    
    }
  }
  
}
