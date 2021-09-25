/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dao;

import gt.com.iot.model.Tank;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author marcos
 */
public interface TankDao extends CrudRepository<Tank, Integer> {
    
}
