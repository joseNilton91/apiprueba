package apifestivo.apifestivo.controlador;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import apifestivo.apifestivo.interfaces.IFestivos;
import apifestivo.apifestivo.modelo.Festivo;

@RestController
@RequestMapping("/festivos")
public class ControladorFestivo {

    private IFestivos servicio;

    public ControladorFestivo(IFestivos servicio) {
        this.servicio = servicio;
    }
    
    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/verificar/{año}/{mes}/{dia}", method = RequestMethod.GET)
    public String verificarFestivo(@PathVariable int año, @PathVariable int mes, @PathVariable int dia) {

        if (servicio.esFechaValida(String.valueOf(año) + "-" + String.valueOf(mes) + "-" + String.valueOf(dia))) {

            Date fecha = new Date(año - 1900, mes - 1, dia);
            return servicio.esFestivo(fecha) ? "Es Festivo" : "No es festivo";
        } else {
            return " Fecha no valida";
        }

    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/obteneraño/{año}", method = RequestMethod.GET)
    public Festivo obtenerAños(@PathVariable int año) {
        return servicio.obtenerAños(año);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/obtener/{mes}", method = RequestMethod.GET)
    public Festivo obtenerMeses(@PathVariable int mes) {
        return servicio.obtenerMeses(mes);

    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/obtenerdia/{dia}", method = RequestMethod.GET)
    public Festivo obtenerDias(@PathVariable int dia) {
        return servicio.obtenerDias(dia);
    }

    @CrossOrigin(origins = "http://localhost:4200/")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }
}

