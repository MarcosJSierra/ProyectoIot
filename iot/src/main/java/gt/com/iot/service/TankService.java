/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Tank;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author marcos
 */
@Service
public interface TankService {
    
    public Tank getTankByID(Integer tankId);
    
    public Tank createTank(Tank newTank);
    
    public Tank updateTank(Tank tank);
    
    public void deleteTank(Tank tank);
    
    public ArrayList<Tank> getAll();
}
