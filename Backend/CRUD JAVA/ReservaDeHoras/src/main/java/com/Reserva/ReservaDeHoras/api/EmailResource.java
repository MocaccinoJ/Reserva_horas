package com.Reserva.ReservaDeHoras.api;

import com.Reserva.ReservaDeHoras.dao.EmailDAO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmailResource {
    // Método para enviar correos
    @RequestMapping(method = RequestMethod.POST, value = "/registro/exito")
    public void enviarCorreo(@RequestParam String destinatario, @RequestParam String asunto,
                             @RequestParam String cuerpo){
        new EmailDAO().enviarConGMail(destinatario,asunto,cuerpo);
    }
}
