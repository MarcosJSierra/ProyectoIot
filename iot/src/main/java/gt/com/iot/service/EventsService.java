/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Event;
import gt.com.iot.model.Sensor;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface EventsService {
      
    public Event getEventByID(Integer eventId);
    
    public ArrayList<Event> getEventsBySensor(Integer sensorId);
    
    public Event createEvent(Event newEvents);
    
    public Event updateEvent(Event tank);
    
    public void deleteEvent(Event tank);
    
    public ArrayList<Event> getAll();
    
}
