/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.SensorLectureQuery;
import gt.com.iot.dto.StatisticsQuery;
import gt.com.iot.model.SensorLecture;
import gt.com.iot.repository.SensorLecturesRepository;
import java.util.ArrayList;
import java.util.List;
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
    public ArrayList<SensorLectureQuery> getAll() {
        ArrayList<SensorLecture> sensorLectures = (ArrayList<SensorLecture>) sensorLecRepo.findAll();
        return formatDate(sensorLectures);
    }

    @Override
    @Transactional(readOnly = true)
    public StatisticsQuery getLectureFromDateToDate(String startDate, String endDate) {
        StatisticsQuery statistics = new StatisticsQuery(0.0, 0L, 0L, 0);
        ArrayList<SensorLecture> sensorLectures
                = (ArrayList<SensorLecture>) sensorLecRepo.queryByDates(Long.parseLong(startDate), Long.parseLong(endDate));
        sensorLectures.stream().filter(sensorLecture -> (sensorLecture.getLecture() > statistics.getMaximo())).forEachOrdered(sensorLecture -> {
            statistics.setMaximo(sensorLecture.getLecture());
        });
        sensorLectures.stream().filter(sensorLecture -> (sensorLecture.getLecture() < statistics.getMinimo())).forEachOrdered(sensorLecture -> {
            statistics.setMinimo(sensorLecture.getLecture());
        });
        sensorLectures.forEach(sensorLecture -> {
            statistics.setPromedio(statistics.getPromedio() + sensorLecture.getLecture().doubleValue());
        });
        statistics.setTotal(sensorLectures.size());
        statistics.setSensorLectures(formatDate(sensorLectures));
        return statistics;
    }

    public ArrayList<SensorLectureQuery> formatDate(List<SensorLecture> sensorLectures) {
        ArrayList<SensorLectureQuery> sensorLectureList = new ArrayList<>();
        sensorLectures.stream().map(sensorLecture -> {
            SensorLectureQuery sensorLectureQuery = new SensorLectureQuery();
            sensorLectureQuery.setIdDatosSensor(sensorLecture.getIdDatosSensor());
            sensorLectureQuery.setLectureDate(sensorLecture.getTimeLecture());
            sensorLectureQuery.setLecture(sensorLecture.getLecture());
            sensorLectureQuery.setIdSensor(sensorLecture.getSensor().getIdSensor());
            return sensorLectureQuery;
        }).forEachOrdered(sensorLectureQuery -> {
            sensorLectureList.add(sensorLectureQuery);
        });
        return sensorLectureList;
    }

}
