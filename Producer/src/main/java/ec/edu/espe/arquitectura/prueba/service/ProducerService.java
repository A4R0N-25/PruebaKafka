/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.prueba.service;

import ec.edu.espe.arquitectura.prueba.dto.MensajeDto;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author bran-
 */
@Service
@Slf4j
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void generar(int numero) {

        Random random = new Random();
        
        Calendar calendario = Calendar.getInstance();
        
        for (int i = 0; i < numero; i++) {
            Date fecha = new Date();
            MensajeDto mensajeDto = MensajeDto.builder()
                    .codigo(random.nextInt(8999999)+1000000)
                    .pago(random.nextFloat()+1)
                    .fechaPago(fecha)
                    .horaPago(String.valueOf(calendario.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(calendario.get(Calendar.MINUTE))+":"+String.valueOf(calendario.get(Calendar.SECOND)))
                    .numeroCuota(random.nextInt(999999999)+1)
                    .build();
            
            log.info(mensajeDto.toString());
            this.enviar(mensajeDto);
        }

    }
    
    @Async
    private void enviar(MensajeDto mensajeDto){
        this.kafkaTemplate.send("prueba", mensajeDto);
    } 

}
