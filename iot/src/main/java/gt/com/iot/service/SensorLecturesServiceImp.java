/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Sensor;
import gt.com.iot.model.SensorLecture;
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
    public SensorLecture getSensorLectureByID(Integer lectureId) {
        return sensorLecRepo.getById(lectureId);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLecture> getSensorLectureBySensor(Integer sensorId) {
        return sensorLecRepo.queryBySensorId(sensorId);
    }

    @Override
    @Transactional
    public void createSensorLectures(SensorLecture newLecture) {
        sensorLecRepo.save(newLecture);
    }
    
    @Override
    @Transactional
    public void updateSensorLectures(SensorLecture lecture) {
        sensorLecRepo.save(lecture);
    }
    
    @Override
    @Transactional
    public void deleteSensorLectures(SensorLecture lecture) {
        sensorLecRepo.delete(lecture);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLecture> getAll() {
        return (ArrayList<SensorLecture>) sensorLecRepo.findAll();
    }
    
}
