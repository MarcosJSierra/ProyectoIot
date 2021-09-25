/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Events;
import gt.com.iot.model.Sensor;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface EventsService {
      
    public Events getEventByID(Integer eventId);
    
    public ArrayList<Events> getEventsBySensor(Sensor sensor);
    
    public void createEvent(Events newEvents);
    
    public void updateEvent(Events tank);
    
    public void deleteEvent(Events tank);
    
    public ArrayList<Events> getAll();
    
}
