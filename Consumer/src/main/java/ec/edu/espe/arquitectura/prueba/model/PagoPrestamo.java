/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.prueba.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;


/**
 *
 * @author bran-
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "PagoPrestamo")
public class PagoPrestamo implements Serializable{

    @Id
    @Column(name = "cod_prestamo", nullable = false)
    private Integer codigo;
    
    @Column(name = "valor_pago", nullable = false, precision = 8, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    
    @Column(name = "hora_pago", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaPago;
    
    @Column(name = "numero_cuota", nullable = false)
    private Integer numeroCuota;
    
}
