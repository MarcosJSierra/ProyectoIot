/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dao;

import gt.com.iot.model.SensorLectures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcos
 */
public interface SensorLecturesDao extends JpaRepository<SensorLectures, Integer>{
    
}
