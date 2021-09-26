/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
@Entity
@Table(name="Event")
public class Event implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public Event(){
    
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEvento")
    private Integer idEvento;
    
    private Integer eventCode;
    
    private Long timeEvent;
    
    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;
}
