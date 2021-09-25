/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.Tank;
import gt.com.iot.repository.SensorRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */

@Service
public class SensorServiceImp implements SensorService{

    @Autowired
    private SensorRepository sensorRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Sensor getSensorByID(Integer sensorId) {
        return sensorRepo.getById(sensorId);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Sensor> getSensorByTank(Integer tankId) {
        return sensorRepo.queryByTankId(tankId);
    }

    @Override
    @Transactional
    public Sensor createSensor(Sensor newSensor) {
        Sensor sensor = sensorRepo.save(newSensor);
        return sensor;
    }

    @Override
    @Transactional
    public Sensor updateSensor(Sensor sensor) {
        Sensor newSensor = sensorRepo.save(sensor);
        return newSensor;
    }

    @Override
    @Transactional
    public void deleteSensor(Sensor sensor) {
        sensorRepo.delete(sensor);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Sensor> getAll() {
        return (ArrayList<Sensor>) sensorRepo.findAll();
    }
    
}
