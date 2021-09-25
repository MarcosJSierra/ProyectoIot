/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.Tank;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface SensorService {
     
    public Sensor getSensorByID(Integer sensorId);
    
    public ArrayList<Sensor> getSensorByTank(Tank tank);
    
    public void createSensor(Sensor newSensor);
    
    public void updateSensor(Sensor sensor);
    
    public void deleteSensor(Sensor sensor);
    
    public ArrayList<Sensor> getAll();
    
}
