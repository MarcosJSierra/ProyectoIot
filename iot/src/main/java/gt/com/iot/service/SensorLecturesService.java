/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.SensorLectures;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface SensorLecturesService {
      
    public SensorLectures getSensorLectureByID(Integer lectureId);
    
    public ArrayList<SensorLectures> getSensorLectureBySensor(Integer sensorId);
    
    public void createSensorLectures(SensorLectures newLecture);
    
    public void updateSensorLectures(SensorLectures lecture);
    
    public void deleteSensorLectures(SensorLectures lecture);
    
    public ArrayList<SensorLectures> getAll();
}
