/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.repository;

import gt.com.iot.model.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marcos
 */
public interface TankRepository extends JpaRepository<Tank, Integer>{
    
}
