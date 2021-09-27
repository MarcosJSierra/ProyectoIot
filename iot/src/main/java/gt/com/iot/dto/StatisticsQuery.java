/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.iot.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Data
public class StatisticsQuery implements Serializable {

    private Double promedio;

    private Long maximo;

    private Long minimo;

    private Integer total;

    private List<SensorLectureQuery> sensorLectures;

    public StatisticsQuery(Double promedio, Long maximo, Long minimo, Integer total) {
        this.promedio = promedio;
        this.maximo = maximo;
        this.minimo = minimo;
        this.total = total;
    }

}
