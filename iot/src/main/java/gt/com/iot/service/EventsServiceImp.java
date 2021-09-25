/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Event;
import gt.com.iot.model.Sensor;
import gt.com.iot.repository.EventsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
public class EventsServiceImp implements EventsService{
    
    @Autowired
    public EventsRepository eventsRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Event getEventByID(Integer eventId) {
        return eventsRepo.getById(eventId);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Event> getEventsBySensor(Integer sensorId) {
        return eventsRepo.queryBySensorId(sensorId);
    }

    @Override
    @Transactional
    public void createEvent(Event newEvents) {
        eventsRepo.save(newEvents);
    }

    @Override
    @Transactional
    public void updateEvent(Event event) {
        eventsRepo.save(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Event event) {
        eventsRepo.delete(event);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Event> getAll() {
        return (ArrayList<Event>) eventsRepo.findAll();
    }
    
    
}
