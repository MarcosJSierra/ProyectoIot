/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author marcos
 */

@Entity
@Data
@Table(name="Sensor")
public class Sensor implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSensor")
    private Integer idSensor;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="state")
    private Boolean state;
    
    @Column(name="tipo")
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name="idTank", referencedColumnName="idTank")
    private Tank tank;
    
    @OneToMany(mappedBy = "sensor")
    private List<SensorLecture> sensorLectures;
    
    @OneToMany(mappedBy = "sensor")
    private List<Event> events;
    
}
