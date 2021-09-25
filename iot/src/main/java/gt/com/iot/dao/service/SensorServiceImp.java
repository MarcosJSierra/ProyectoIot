/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dao.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.Tank;
import gt.com.iot.repository.SensorRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
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
    public ArrayList<Sensor> getSensorByTank(Tank tank) {
        return sensorRepo.queryByTankId(tank.getIdTank());
    }

    @Override
    @Transactional
    public void createSensor(Sensor newSensor) {
        sensorRepo.save(newSensor);
    }

    @Override
    @Transactional
    public void updateSensor(Sensor sensor) {
        sensorRepo.save(sensor);
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
