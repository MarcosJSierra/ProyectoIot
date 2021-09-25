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
@Entity
@Data
@Table(name="SensorLectures")
public class SensorLectures implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDatosSensor")
    private Integer idSensorsLectures;
    
    @Column(name="timestampLecture")
    private Long timeLecture;
    
    @Column(name="lecture")
    private Long lecture;
    
    @ManyToOne
    @JoinColumn(name = "idSensor")
    private Sensor sensor;
}
