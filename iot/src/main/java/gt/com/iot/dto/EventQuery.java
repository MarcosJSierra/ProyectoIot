/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import gt.com.iot.model.Sensor;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class EventQuery {
  
    private Integer idEvento;
    
    private Integer eventCode;
    
    private Long timeEvent;

    private Integer sensorId;
}
