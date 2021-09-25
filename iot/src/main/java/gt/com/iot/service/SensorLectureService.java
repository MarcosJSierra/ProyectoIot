/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.SensorLecture;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface SensorLectureService {
      
    public SensorLecture getSensorLectureByID(Integer lectureId);
    
    public ArrayList<SensorLecture> getSensorLectureBySensor(Integer sensorId);
    
    public SensorLecture createSensorLecture(SensorLecture newLecture);
    
    public SensorLecture updateSensorLecture(SensorLecture lecture);
    
    public void deleteSensorLecture(SensorLecture lecture);
    
    public ArrayList<SensorLecture> getAll();
}
