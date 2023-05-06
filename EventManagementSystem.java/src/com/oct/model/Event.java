package com.oct.model;
import java.util.*;
import java.io.*;
/**
 * Handles a event objects
 * 
 * @author Octavian Ionescu
 */
public class Event implements Serializable{
    private String name, desc;
    private int eventID;
    //The reason I chose HashSet is since I want the collection to not contain duplicates
    Set<Attendee> attendees = new HashSet<Attendee>();
    public Event(int eventID, String name, String desc) throws IOException {
        this.name = name;
        this.eventID = eventID;
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }

    public void setDesc(String desc){
        this.desc = desc;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEventID() {
        return this.eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public Set<Attendee> getAttendees() {
        return this.attendees;
    }

    public void setAttendees(Set<Attendee> attendees) {
        this.attendees = attendees;
    }

    @Override
    public String toString() {
        return "ID : " + this.eventID + "  The Event is called : " + this.name + ". Description : " + this.desc + "\n";
    }
}
