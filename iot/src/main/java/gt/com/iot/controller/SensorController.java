/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.controller;

import gt.com.iot.dto.SensorQuery;
import gt.com.iot.model.Sensor;
import gt.com.iot.service.SensorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:8081")
@RequestMapping(value = "api/sensor")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping("")
    List<Sensor> getSensorList() {
        return sensorService.getAll();
    }

    @GetMapping("/tank/{id}")
    List<Sensor> getSensorListByTank(@PathVariable Integer tankId) {
        return sensorService.getSensorByTank(tankId);
    }

    @GetMapping("/{id}")
    Sensor getSensor(@PathVariable Integer id) {
        return sensorService.getSensorByID(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    Sensor createSensor(SensorQuery sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping("/{id}")
    Sensor updateSensor(@RequestBody SensorQuery sensor, @PathVariable Integer id) {

        return sensorService.updateSensor(sensor);
    }

    @DeleteMapping("/{id}")
    void deleteSensor(@PathVariable SensorQuery sensor) {
        sensorService.deleteSensor(sensor);
    }
}
