package com.oct.cntrl;

import com.oct.model.*;
import com.oct.services.*;

import java.util.*;

public class Controller {
    /**
    * It uses the choice made, a scanner, and the targeted eventset to
    * call the relevant method, as well as take in the relevant input
    * 
    * @param sel
    * @param ch
    * @param eventList
    */
    public static void implementChoice(int sel, Scanner ch, Events eventList){
        String text;
        Event toEdit;
        Utility util = new Utility();
        int number;
        switch(sel){
            case 1:{
                System.out.println(eventList);
                break;
            }
            case 2:{
                System.out.println("PLEASE ENTER ID OF EVENT YOU WANT TO LIST:");
                number = ch.nextInt();
                try{
                    System.out.println(eventList.getEvent(number).toString());
                } catch (NullPointerException e){
                    System.out.println("ID was not found!");
                    break;
                }
                break;
            }
            case 3:{
                System.out.println("PLEASE ENTER ID OF EVENT YOU WANT TO EDIT:");
                number = ch.nextInt();
                ch.nextLine();
                System.out.println("PLEASE ENTER NEW DESCTRIPTION OF EVENT:");
                text = ch.nextLine();
                toEdit = eventList.getEvent(number);
                try{
                    toEdit.setDesc(text);
                } catch (NullPointerException e){
                    System.out.println("ID was not found!");
                    break;
                } 
                System.out.println("Description has been changed!\n");  
                break;
            }
            case 4:{
                System.out.println("PLEASE ENTER ID OF EVENT TO BE REMOVED FROM LIST:");
                number = ch.nextInt();
                ch.nextLine();
                util.deleteEvent(eventList, number);
                System.out.println("Ëvent has been deleted!\n");
                break;
            }
            case 5:{
                System.out.println("PLEASE ENTER ID OF EVENT YOU WANT TO SHOW LIST OF ATTENDANTS:");
                number = ch.nextInt();
                toEdit = eventList.getEvent(number);
                try{
                    System.out.println(toEdit.getAttendees());
                }catch (NullPointerException e){
                    System.out.println("ID was not found!");
                    break;
                }
                break;
            }
            case 6:{
                System.out.println("PLEASE ENTER ID OF EVENT YOU WANT TO ADD AN ATTENDANT TO:");
                number = ch.nextInt();
                toEdit = eventList.getEvent(number);  
                System.out.println("Please Enter Attendee ID:");
                int id = ch.nextInt();
                ch.nextLine();
                System.out.println("Please Enter Attendee Name:");
                text = ch.nextLine();
                System.out.println("Please Enter Attendee Age:");
                int age = ch.nextInt();
                try{
                    util.addAttendee(toEdit, new Attendee(id, age, text));
                } catch (NullPointerException e){
                    System.out.println("ID was not found!");
                    break;
                }
                System.out.println("Attendant has been added!\n");             
                break;
            }
            case 7:{
                System.out.println("PLEASE ENTER ID OF EVENT YOU WANT TO DELETE AN ATTENDANT FROM:\n");
                number = ch.nextInt();
                toEdit = eventList.getEvent(number);
                System.out.println("PLEASE ENTER ID OF ATTENDEE TO BE DELETED: \n");
                number = ch.nextInt();
                try{
                    util.deleteAttendee(toEdit, number);
                } catch (NullPointerException e){
                    System.out.println("ID was not found!");
                    break;
                }
                System.out.println("Attendant has been deleted!\n");
                break;
            } 
        }
        
    }
}
