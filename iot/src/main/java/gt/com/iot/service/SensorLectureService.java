/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.dto.SensorLectureQuery;
import gt.com.iot.dto.StatisticsQuery;
import gt.com.iot.model.SensorLecture;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface SensorLectureService {

    public SensorLecture getSensorLectureByID(Integer lectureId);

    public ArrayList<SensorLecture> getSensorLectureBySensor(Integer sensorId);

    public SensorLecture createSensorLecture(SensorLectureQuery newLecture);

    public SensorLecture updateSensorLecture(SensorLectureQuery lecture);

    public void deleteSensorLecture(SensorLectureQuery lecture);

    public ArrayList<SensorLectureQuery> getAll();

    public StatisticsQuery getLectureFromDateToDate(String startDate, String endDate);
}
