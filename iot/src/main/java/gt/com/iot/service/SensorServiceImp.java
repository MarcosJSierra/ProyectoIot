/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.SensorQuery;
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
    
    @Autowired
    private TankServiceImp tankService; 
    
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
    public Sensor createSensor(SensorQuery newSensor) {
        Sensor sensorM = new Sensor();
        sensorM.setName(newSensor.getName());
        sensorM.setDescription(newSensor.getDescription());
        sensorM.setTank(tankService.getTankByID(newSensor.getIdTank()));
        sensorM.setState(newSensor.getState());
        sensorM.setType(newSensor.getType());
        Sensor sensor = sensorRepo.save(sensorM);
        return sensor;
    }

    @Override
    @Transactional
    public Sensor updateSensor(SensorQuery sensor) {
        Sensor sensorM = new Sensor();
        sensorM.setIdSensor(sensor.getIdSensor());
        sensorM.setName(sensor.getName());
        sensorM.setDescription(sensor.getDescription());
        sensorM.setTank(tankService.getTankByID(sensor.getIdTank()));
        sensorM.setState(sensor.getState());
        sensorM.setType(sensor.getType());
        Sensor newSensor = sensorRepo.save(sensorM);
        return newSensor;
    }

    @Override
    @Transactional
    public void deleteSensor(SensorQuery sensor) {
        Sensor sensorM = new Sensor();
        sensorM.setIdSensor(sensor.getIdSensor());
        sensorM.setName(sensor.getName());
        sensorM.setDescription(sensor.getDescription());
        sensorM.setTank(tankService.getTankByID(sensor.getIdTank()));
        sensorM.setState(sensor.getState());
        sensorM.setType(sensor.getType());
        sensorRepo.delete(sensorM);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Sensor> getAll() {
        return (ArrayList<Sensor>) sensorRepo.findAll();
    }
    
}
