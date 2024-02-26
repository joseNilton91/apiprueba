package apifestivo.apifestivo.Controladores;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apifestivo.apifestivo.Entidades.Festivo;
import apifestivo.apifestivo.Interfaces.IFestivoServicio;

@RestController
@RequestMapping("/festivos")
public class FestivoControlador {
    @Autowired
    private IFestivoServicio servicio;

    @CrossOrigin(origins = "")
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificarfestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {
        if (servicio.esFechaValida(String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia))) {
            Date fecha = new Date(año - 1900, mes - 1, dia);
            return servicio.esFestivo(fecha) ? "Es festivo" : "No es festivo";

        } else {
            return "Fecha no valida";
        }
    }

    @RequestMapping(value = "/obtenerFestivos/{año}", method = RequestMethod.GET)
    public Festivo obtenerfFestivos(@PathVariable int año) {
        return (Festivo) servicio.obtenerFestivos(año);
    }
}
