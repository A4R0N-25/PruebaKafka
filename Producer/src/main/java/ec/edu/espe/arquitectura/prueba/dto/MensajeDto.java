/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.prueba.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author bran-
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MensajeDto {
    
    private Integer codigo;
    private Float pago;
    private Date  fechaPago;
    private String horaPago;
    private Integer numeroCuota;
    
}
