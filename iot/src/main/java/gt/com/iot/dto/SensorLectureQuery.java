/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class SensorLectureQuery implements Serializable{

    private Integer idDatosSensor;

    private Long timeLecture;

    private Long lecture;

    private Integer idSensor;

    private String lectureDate;

    public String setLectureDate(Long time) {
        Timestamp timestamp = new Timestamp(time);
        Date date = new Date(timestamp.getTime());
        return this.lectureDate = date.toString();
    }
}
