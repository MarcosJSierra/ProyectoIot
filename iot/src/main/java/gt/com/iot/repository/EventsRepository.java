/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.repository;

import gt.com.iot.model.Event;
import gt.com.iot.model.SensorLecture;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marcos
 */
@Repository
public interface EventsRepository extends JpaRepository<Event, Integer>{

    @Query (value = "SELECT * FROM Events WHERE Events.idSensor = :idSensor", nativeQuery = true)
    ArrayList<Event> queryBySensorId(@Param("idSensor") Integer idSensor);
}