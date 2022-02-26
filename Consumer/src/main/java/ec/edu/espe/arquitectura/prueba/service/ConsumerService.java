/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dto.MensajeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ec.edu.espe.arquitectura.prueba.dao.PagoPrestamoRepository;
import ec.edu.espe.arquitectura.prueba.model.PagoPrestamo;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author bran-
 */
@Service
@Slf4j
public class ConsumerService {
    
    @Autowired
    private PagoPrestamoRepository pagoPrestamoRepository;
    
    @KafkaListener(topics = {"prueba"}, groupId = "test")
    public void consumer(MensajeDto mensaje) throws ParseException{
        Date date = new SimpleDateFormat("hh:mm:ss").parse(mensaje.getHoraPago());
        PagoPrestamo pagoPrestamo = new PagoPrestamo();
        pagoPrestamo.setCodigo(mensaje.getCodigo());
        pagoPrestamo.setValorPago(BigDecimal.valueOf(mensaje.getPago()));
        pagoPrestamo.setFechaPago(mensaje.getFechaPago());
        pagoPrestamo.setHoraPago(new Timestamp(date.getTime()));
        pagoPrestamo.setNumeroCuota(mensaje.getNumeroCuota());
        this.pagoPrestamoRepository.save(pagoPrestamo);
        log.info("Mensaje Recibido: {}", pagoPrestamo);
    }
    
}
