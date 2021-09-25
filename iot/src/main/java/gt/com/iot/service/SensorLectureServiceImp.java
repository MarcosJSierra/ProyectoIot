/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.SensorLecture;
import gt.com.iot.repository.SensorLecturesRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
public class SensorLectureServiceImp implements SensorLectureService{

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
    public SensorLecture createSensorLecture(SensorLecture newLecture) {
        SensorLecture lecture = sensorLecRepo.save(newLecture);
        return lecture;
    }
    
    @Override
    @Transactional
    public SensorLecture updateSensorLecture(SensorLecture lecture) {
        SensorLecture lectureE = sensorLecRepo.save(lecture);
        return lectureE;
    }
    
    @Override
    @Transactional
    public void deleteSensorLecture(SensorLecture lecture) {
        sensorLecRepo.delete(lecture);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLecture> getAll() {
        return (ArrayList<SensorLecture>) sensorLecRepo.findAll();
    }
    
}
