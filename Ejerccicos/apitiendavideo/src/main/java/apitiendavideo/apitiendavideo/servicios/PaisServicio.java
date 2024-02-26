package apitiendavideo.apitiendavideo.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import apitiendavideo.apitiendavideo.entidades.Pais;
import apitiendavideo.apitiendavideo.interfaces.IPaisservicio;
import apitiendavideo.apitiendavideo.repositorios.PaisRepositorio;

@Service
public class PaisServicio implements IPaisservicio {

    private PaisRepositorio repositorio;

    public PaisServicio(PaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtener(long id) {
     var pais =repositorio.findById(id);
     return pais.isEmpty()?null: pais.get();
    }

    @Override
    public List<Pais> buscar(String nombre) {
        return  repositorio.buscar(nombre);

    }

    @Override
    public Pais guardar(Pais pais) {
    
        return repositorio.save(pais);
    }

    @Override
    public boolean eliminar(long id) {
        try {
             repositorio.deleteById(id);
             return true;
        } catch (Exception ex) {
            return false;
        }
       
        
    }

}
