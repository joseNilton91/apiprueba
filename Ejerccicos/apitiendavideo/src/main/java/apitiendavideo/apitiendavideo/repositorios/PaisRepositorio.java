package apitiendavideo.apitiendavideo.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import apitiendavideo.apitiendavideo.entidades.Pais;

public interface PaisRepositorio extends JpaRepository<Pais,Long>{

    @Query("select p from Pais p where p.nombre like '%' || ?1 || '%' ")
    public List<Pais> buscar(String nombre);
    
}
