/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import gt.com.iot.model.Sensor;
import java.io.Serializable;
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
    
    private Integer sensorId;
  
}
