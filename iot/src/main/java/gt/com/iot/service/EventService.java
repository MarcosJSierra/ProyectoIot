/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.EventQuery;
import gt.com.iot.model.Event;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author marcos
 */
public interface EventService {
      
    public Event getEventByID(Integer eventId);
    
    public ArrayList<Event> getEventsBySensor(Integer sensorId);
    
    public Event createEvent(EventQuery newEvent);
    
    public Event updateEvent(EventQuery event);
    
    public void deleteEvent(EventQuery event);
    
    public ArrayList<Event> getAll();
    
}
