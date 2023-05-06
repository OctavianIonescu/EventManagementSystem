package com.oct.DAO;
import java.util.*;
import java.io.*;
/**
* Interface created to help with implementing file functionality to the project
* At the moment it is not being used
* @author Octavian Ionescu
*/
public interface FileHandling {
    /**
    * Default implementation that ensures file population from a set
    * 
    * @param setName
    * @param fileName
    */
    default void setFileFromSet(Set setName, File fileName ){
        FileOutputStream fileOut;
        ObjectOutputStream objectOut;
        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.print("");
            writer.close();
            fileOut = new FileOutputStream(fileName);
            objectOut = new ObjectOutputStream(fileOut);
            Iterator<Object> itr = setName.iterator();
            while(itr.hasNext()){
                objectOut.writeObject(itr.next());
            } 
            System.out.println("The Set has been written on the file\n");
            objectOut.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
    * Default implementation that ensures set population from file
    * 
    * @param setName
    * @param fileName
    */
    default void setSetFromFile(Set setName, File fileName){
        FileInputStream fileIn;
        ObjectInputStream objectIn;
        try {
            if(fileName.createNewFile()){
                System.out.println("New File Created: " + fileName + "\n");
            }
            else {
                System.out.println(fileName.getName() + " already exists, uploading progress!\n");
            }
            fileIn = new FileInputStream(fileName);
            objectIn = new ObjectInputStream(fileIn);
            Object x = objectIn.readUnshared();
            while(x != null){
                setName.add(x);
                x = objectIn.readUnshared();
            }  
            objectIn.close();
        } catch (EOFException eof){
            System.out.println("The Set has been updated in accordance to the file\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
