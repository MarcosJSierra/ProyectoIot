/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.controller;

import gt.com.iot.dto.SensorLectureQuery;
import gt.com.iot.model.SensorLecture;
import gt.com.iot.service.SensorLectureService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping(value = "api/sensorlecture")
public class SensorLectureController {

    @Autowired
    private SensorLectureService lectureService;

    @GetMapping("")
    List<SensorLecture> getSensorList() {
        return lectureService.getAll();
    }

    @GetMapping("/sensor/{id}")
    List<SensorLecture> getSensorLectureListBySensor(@PathVariable Integer sensorId) {
        return lectureService.getSensorLectureBySensor(sensorId);
    }

    @GetMapping("/{id}")
    SensorLecture getSensorLecture(@PathVariable Integer id) {
        return lectureService.getSensorLectureByID(id);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    SensorLecture createSensorLecture(SensorLectureQuery sensorLecture) {
        return lectureService.createSensorLecture(sensorLecture);
    }

    @PutMapping("/{id}")
    SensorLecture updateSensorLecture(@RequestBody SensorLectureQuery sensorLecture, @PathVariable Integer id) {
        return lectureService.updateSensorLecture(sensorLecture);
    }

    @DeleteMapping("/{id}")
    void deleteSensorLecture(@PathVariable SensorLectureQuery sensorLecture) {
        lectureService.deleteSensorLecture(sensorLecture);
    }
}
