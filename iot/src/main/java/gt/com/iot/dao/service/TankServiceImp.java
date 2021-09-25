/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dao.service;

import gt.com.iot.dao.TankDao;
import gt.com.iot.model.Tank;
import gt.com.iot.repository.TankRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
public class TankServiceImp implements TankService{
    
    @Autowired
    private TankRepository tankRepo;

    @Override
    @Transactional(readOnly = true)
    public Tank getTankByID(Integer tankId) {
        return tankRepo.getById(tankId);
    }

    @Override
    @Transactional
    public void createTank(Tank newTank) {
        tankRepo.save(newTank);
    }

    @Override
    @Transactional
    public void updateTank(Tank tank) {
        tankRepo.save(tank);
    }

    @Override
    @Transactional
    public void deleteTank(Tank tank) {
        tankRepo.delete(tank);
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList<Tank> getAll() {
        return (ArrayList<Tank>)tankRepo.findAll();
    }
    
}
