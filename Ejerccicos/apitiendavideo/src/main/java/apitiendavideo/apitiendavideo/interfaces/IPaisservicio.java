package apitiendavideo.apitiendavideo.interfaces;

import java.util.List;

import apitiendavideo.apitiendavideo.entidades.Pais;

public interface IPaisservicio {
    public List<Pais> listar();

    public Pais obtener(long id);

    public List<Pais> buscar(String nombre);

    public Pais guardar(Pais pais);

    public boolean eliminar(long id);

}
