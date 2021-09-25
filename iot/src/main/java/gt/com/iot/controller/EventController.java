/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.controller;

import gt.com.iot.model.Event;
import gt.com.iot.service.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping(value = "api/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("")
    List<Event> getEventList() {
        return eventService.getAll();
    }

    @GetMapping("/sensor/{id}")
    List<Event> getEventListBySensor(@PathVariable Integer sensorId) {
        return eventService.getEventsBySensor(sensorId);
    }

    @GetMapping("/{id}")
    Event getEvent(@PathVariable Integer id) {
        return eventService.getEventByID(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Event createEvent(Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{id}")
    Event updateEvent(@RequestBody Event event, @PathVariable Integer id) {
        Event oldEvent = eventService.getEventByID(id);
        oldEvent.setEventCode(event.getEventCode());
        oldEvent.setTimeEvent(event.getTimeEvent());
        oldEvent.setSensor(event.getSensor());
        return eventService.updateEvent(oldEvent);
    }

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable Event event) {
        eventService.deleteEvent(event);
    }
}
