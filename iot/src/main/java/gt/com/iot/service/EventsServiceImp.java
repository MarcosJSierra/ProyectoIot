/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Events;
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
    public Events getEventByID(Integer eventId) {
        return eventsRepo.getById(eventId);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Events> getEventsBySensor(Sensor sensor) {
        return eventsRepo.queryBySensorId(sensor.getIdSensor());
    }

    @Override
    @Transactional
    public void createEvent(Events newEvents) {
        eventsRepo.save(newEvents);
    }

    @Override
    @Transactional
    public void updateEvent(Events event) {
        eventsRepo.save(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Events event) {
        eventsRepo.delete(event);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Events> getAll() {
        return (ArrayList<Events>) eventsRepo.findAll();
    }
    
    
}
