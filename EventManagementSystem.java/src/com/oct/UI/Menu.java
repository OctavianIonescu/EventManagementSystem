package com.oct.UI;
import java.util.*;
import java.io.*;
/**
 * Class responsible for handling menu related methods
 * @author Octavian Ionescu
 */
public class Menu {
    
    static File File = new File("src/File.txt");
    /**
     * It accesses the file containing the menu, showing it on the terminal
     */
    public static void shMenu() {
        try {
            Reader r = new FileReader(File);
            BufferedReader r1 = new BufferedReader(r);
            String x = r1.readLine();
            while(x != null){
                System.out.println(x);
                x = r1.readLine();
            }
            
            r1.close();
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * It uses the provided scanner to get your choice from terminal, ensuring
     * it is a valid entry
     * 
     * @param ch
     * @return sel
     */
    public static int collectChoice(Scanner ch) {
        int sel = 0;
        try{
            sel = ch.nextInt();
            System.out.println("\n\n");
        }catch (Exception e){
            ch.next();
            System.out.println("\nPLEASE ENTER A VALID MENU ENTRY\n");
            sel = collectChoice(ch);
        }
        if(sel <= 0 || sel >= 8){//RANGE OF DISAPPROVED MENU COMMANDS
            if(sel == 8){//EXIT CLAUSE VALUE
                System.out.println("\n*********************************GOODBYE************************************\n");
                return sel;
            }
            System.out.println("\nPLEASE ENTER A VALID MENU ENTRY\n");
            sel = collectChoice(ch);
        }
        return sel;
        
    }

    /**
     * It causes a break in the execution of the program to give the user time
     * to read the results from the previous query
     */
    public static void pressEnterKeyToContinue()
    { 
            System.out.println("Press Enter key to continue...");
            Scanner s = new Scanner(System.in);
            s.nextLine();
    }
    
    public static int menuExp(Scanner ch){
        shMenu();
        return collectChoice(ch);
    }
}
