/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.repository;

import gt.com.iot.model.SensorLectures;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author marcos
 */
public interface SensorLecturesRepository extends JpaRepository<SensorLectures, Integer> {
    @Query (value = "SELECT * FROM SensorLectures WHERE SensorLectures.idSensor = :idSensor", nativeQuery = true)
    ArrayList<SensorLectures> queryBySensorId(@Param("idSensor") Integer idSensor);
}
