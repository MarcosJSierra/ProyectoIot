/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.controller;

import gt.com.iot.model.Tank;
import gt.com.iot.service.TankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping(value = "api/tank")
public class TankController {

    @Autowired
    private TankService tankService;

    @GetMapping("")
    List<Tank> getSensorList() {
        return tankService.getAll();
    }

    @GetMapping("/{id}")
    Tank getTank(@PathVariable Integer id) {
        return tankService.getTankByID(id);
    }

    @PostMapping("")
    Tank createTank(@RequestBody Tank tank) {
        return tankService.createTank(tank);
    }

    @PutMapping("/{id}")
    Tank updateTank(@RequestBody Tank tank, @PathVariable Integer id) {
        Tank olTank = tankService.getTankByID(id);
        olTank.setName(tank.getName());
        olTank.setDescription(tank.getDescription());
        olTank.setUnits(tank.getUnits());
        olTank.setMaxVolume(tank.getMaxVolume());
        olTank.setFullread(tank.getFullread());
        olTank.setEmptyread(tank.getEmptyread());
        olTank.setStateCode(tank.getStateCode());
        return tankService.updateTank(olTank);
    }

    @DeleteMapping("/{id}")
    void deleteTank(@PathVariable Tank tank) {
        tankService.deleteTank(tank);
    }
}
