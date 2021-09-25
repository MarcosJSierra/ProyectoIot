/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.repository;

import gt.com.iot.model.Sensor;
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
public interface SensorRepository extends JpaRepository<Sensor, Integer>{
    @Query (value = "SELECT * FROM Sensor WHERE Sensor.idTank = :idTank", nativeQuery = true)
    ArrayList<Sensor> queryByTankId(@Param("idTank") Integer idTank);
    
}
