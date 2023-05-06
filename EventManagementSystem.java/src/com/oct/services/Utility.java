package com.oct.services;
import com.oct.DAO.FileHandling;
import com.oct.model.*;

public class Utility implements FileHandling{
    /**
    * Adds an event to the list of events
    * 
    * @param event
    */
    public void addEvent(Events events, Event event){
        events.getEvents().add(event);
    }
    
    
    /**
    * Deletes an event from the event list
    * 
    * @param id
    */
    public void deleteEvent(Events events, int id) {
        events.getEvents().removeIf(x -> x.getEventID() == id);
    }
    /**
     * Closes file,ensures saving
     * @param events
     */
    public void close(Events events){
        setFileFromSet(events.getEvents(), events.getFile());
    }

     /**
     * Adds an attendee to the list of attendees
     * 
     * @param info
     */
    public void addAttendee(Event event, Attendee info){
        event.getAttendees().add(info);
    }

    /**
     * Removes an attendee from the lis of attendees based on ID
     * 
     * @param id
     */
    public void deleteAttendee(Event event, int id){
        event.getAttendees().removeIf(x -> x.getId() == id);
    }
}
