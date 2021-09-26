/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.EventQuery;
import gt.com.iot.model.Event;
import gt.com.iot.model.Sensor;
import gt.com.iot.repository.EventsRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
@Service
public class EventServiceImp implements EventService{
    
    @Autowired
    public EventsRepository eventsRepo;
    
    @Autowired
    public SensorServiceImp sensorService;
    
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
    public Event createEvent(EventQuery newEvent) {
        Event newEvents = new Event();
        newEvents.setEventCode(newEvent.getEventCode());
        newEvents.setTimeEvent(newEvent.getTimeEvent());
        newEvents.setSensor(sensorService.getSensorByID(newEvent.getSensorId()));
        Event nuevo = eventsRepo.save(newEvents);
        return nuevo;
        
    }

    @Override
    @Transactional
    public Event updateEvent(EventQuery event) {
        Event eventoM = new Event();
        eventoM.setIdEvento(event.getIdEvento());
        eventoM.setEventCode(event.getEventCode());
        eventoM.setTimeEvent(event.getTimeEvent());
        eventoM.setSensor(sensorService.getSensorByID(event.getSensorId()));
        Event editado = eventsRepo.save(eventoM);
        return editado;
    }

    @Override
    @Transactional
    public void deleteEvent(EventQuery event) {
        Event eventoM = new Event();
        eventoM.setIdEvento(event.getIdEvento());
        eventoM.setEventCode(event.getEventCode());
        eventoM.setTimeEvent(event.getTimeEvent());
        eventoM.setSensor(sensorService.getSensorByID(event.getSensorId()));
        eventsRepo.delete(eventoM);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Event> getAll() {
        return (ArrayList<Event>) eventsRepo.findAll();
    }
    
    
}
