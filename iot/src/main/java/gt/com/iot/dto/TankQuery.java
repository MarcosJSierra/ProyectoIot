/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class TankQuery implements Serializable{

    private Integer idTank;
    
    private String name;
    
    private String description;
    
    private String units;
    
    private Double maxVolume;
    
    private Double fullread;
    
    private Double emptyread;
    
    private Integer stateCode;
}
