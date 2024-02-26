package apitiendavideo.apitiendavideo.controladores;

import java.util.*;

import org.springframework.web.bind.annotation.*;
import apitiendavideo.apitiendavideo.entidades.Pais;
import apitiendavideo.apitiendavideo.interfaces.IPaisservicio;

@RestController
@RequestMapping("/paises")
public class PaisControlador {

    private IPaisservicio servicio;

    public PaisControlador(IPaisservicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pais> listar() {
        return servicio.listar();
    }

    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Pais obtener(@PathVariable long id) {
        return servicio.obtener(id);
    }

    @RequestMapping(value = "/buscar/{nombre}", method = RequestMethod.GET)
    public List<Pais> bsucar(@PathVariable String nombre) {
        return servicio.buscar(nombre);
    }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Pais agregar(@RequestBody Pais pais) {
        pais.setId(0);
        return servicio.guardar(pais);
    }

    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Pais modificar(@RequestBody Pais pais) {
        if (servicio.obtener(pais.getId()) != null) {
            return servicio.guardar(pais);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public Boolean eliminar(@PathVariable long id) {
        return servicio.eliminar(id);
    }

}