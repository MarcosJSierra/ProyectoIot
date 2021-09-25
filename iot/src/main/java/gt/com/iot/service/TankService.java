/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.service;

import gt.com.iot.model.Tank;
import java.util.ArrayList;

/**
 *
 * @author marcos
 */
public interface TankService {
    
    public Tank getTankByID(Integer tankId);
    
    public void createTank(Tank newTank);
    
    public void updateTank(Tank tank);
    
    public void deleteTank(Tank tank);
    
    public ArrayList<Tank> getAll();
}
