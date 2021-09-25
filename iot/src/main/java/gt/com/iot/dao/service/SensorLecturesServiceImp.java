/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dao.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.SensorLectures;
import gt.com.iot.repository.SensorLecturesRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
public class SensorLecturesServiceImp implements SensorLecturesService{

    @Autowired
    private SensorLecturesRepository sensorLecRepo;
    
    @Override
    @Transactional(readOnly = true)
    public SensorLectures getSensorLectureByID(Integer lectureId) {
        return sensorLecRepo.getById(lectureId);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLectures> getSensorLectureBySensor(Sensor sensor) {
        return sensorLecRepo.queryBySensorId(sensor.getIdSensor());
    }

    @Override
    @Transactional
    public void createSensorLectures(SensorLectures newLecture) {
        sensorLecRepo.save(newLecture);
    }
    
    @Override
    @Transactional
    public void updateSensorLectures(SensorLectures lecture) {
        sensorLecRepo.save(lecture);
    }
    
    @Override
    @Transactional
    public void deleteSensorLectures(SensorLectures lecture) {
        sensorLecRepo.delete(lecture);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLectures> getAll() {
        return (ArrayList<SensorLectures>) sensorLecRepo.findAll();
    }
    
}
