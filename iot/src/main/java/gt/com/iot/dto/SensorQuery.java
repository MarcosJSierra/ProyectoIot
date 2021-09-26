/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import gt.com.iot.model.Sensor;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class SensorQuery implements Serializable{
    
   
    private Integer idSensor;
    
    private String name;
    
    private String description;
    
    private Boolean state;
    
    private String type;
    
    private Integer idTank;
}
