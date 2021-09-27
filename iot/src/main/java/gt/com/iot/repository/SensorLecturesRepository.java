/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.repository;

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
public interface SensorLecturesRepository extends JpaRepository<SensorLecture, Integer> {
    @Query (value = "SELECT * FROM SensorLectures WHERE SensorLectures.idSensor = :idSensor", nativeQuery = true)
    ArrayList<SensorLecture> queryBySensorId(@Param("idSensor") Integer idSensor);

    @Query(value = "SELECT * FROM SensorLectures WHERE timeLecture >= :startDate AND timeLecture <= :endDate", nativeQuery = true)
    ArrayList<SensorLecture> queryByDates(@Param("startDate") Long startDate, @Param("endDate") Long endDate);
}
