package com.oct.model;
import com.oct.DAO.*;
import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
* Class that ensures the handling of all event objects
* 
* @author Octavian Ionescu
*/
public class Events implements FileHandling, Serializable {
    Set<Event> events = new HashSet<Event>();
    File mainFile = new File("src/EventsFile.dat");
    public Events() {
        setSetFromFile(this.events, mainFile);
    }

    public Set<Event> getEvents() {
        return events;
    } 
    
    /**
    * Searches for an event in the list of events based on event ID
    * 
    * @param ID
    * @return event
    */
    public Event getEvent(int ID){
        Iterator<Event> itr = events.iterator();
        while(itr.hasNext()){
            Event x = itr.next();
            if(x.getEventID() == ID){
                return x;
            }
        }
        return null; 
    }
    
    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public File getFile(){
        return this.mainFile;
    }
    
    @Override
    public String toString() {
        String res = "";
        for(Event e : this.events){
            res = res + e.toString();
        }
        return res;
    }
    
}
