/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.controller;

import gt.com.iot.model.Sensor;
import gt.com.iot.service.SensorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("")
    Sensor createSensor(@RequestBody Sensor sensor) {
        return sensorService.createSensor(sensor);
    }

    @PutMapping("/{id}")
    Sensor updateSensor(@RequestBody Sensor sensor, @PathVariable Integer id) {
        Sensor oldSensor = sensorService.getSensorByID(id);
        oldSensor.setName(sensor.getName());
        oldSensor.setDescription(sensor.getDescription());
        oldSensor.setState(sensor.getState());
        oldSensor.setType(sensor.getType());
        oldSensor.setTank(sensor.getTank());
        return sensorService.updateSensor(oldSensor);
    }

    @DeleteMapping("/{id}")
    void deleteSensor(@PathVariable Sensor sensor) {
        sensorService.deleteSensor(sensor);
    }
}
