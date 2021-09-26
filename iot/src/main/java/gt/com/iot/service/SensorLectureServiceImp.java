/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.SensorLectureQuery;
import gt.com.iot.model.SensorLecture;
import gt.com.iot.repository.SensorLecturesRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */

@Service
public class SensorLectureServiceImp implements SensorLectureService{

    @Autowired
    private SensorLecturesRepository sensorLecRepo;
    
    @Autowired
    private SensorServiceImp sensorService;
    
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
    public SensorLecture createSensorLecture(SensorLectureQuery newLecture) {
        SensorLecture lectureM =  new SensorLecture();
        lectureM.setLecture(newLecture.getLecture());
        lectureM.setTimeLecture(newLecture.getTimeLecture());
        lectureM.setSensor(sensorService.getSensorByID(newLecture.getIdSensor()));
        SensorLecture lecture = sensorLecRepo.save(lectureM);
        return lecture;
    }
    
    @Override
    @Transactional
    public SensorLecture updateSensorLecture(SensorLectureQuery lecture) {
        SensorLecture lectureM =  new SensorLecture();
        lectureM.setIdDatosSensor(lecture.getIdDatosSensor());
        lectureM.setLecture(lecture.getLecture());
        lectureM.setTimeLecture(lecture.getTimeLecture());
        lectureM.setSensor(sensorService.getSensorByID(lecture.getIdSensor()));
        SensorLecture lectureE = sensorLecRepo.save(lectureM);
        return lectureE;
    }
    
    @Override
    @Transactional
    public void deleteSensorLecture(SensorLectureQuery lecture) {
        SensorLecture lectureM =  new SensorLecture();
        lectureM.setIdDatosSensor(lecture.getIdDatosSensor());
        lectureM.setLecture(lecture.getLecture());
        lectureM.setTimeLecture(lecture.getTimeLecture());
        lectureM.setSensor(sensorService.getSensorByID(lecture.getIdSensor()));
        sensorLecRepo.delete(lectureM);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<SensorLecture> getAll() {
        return (ArrayList<SensorLecture>) sensorLecRepo.findAll();
    }
    
}
