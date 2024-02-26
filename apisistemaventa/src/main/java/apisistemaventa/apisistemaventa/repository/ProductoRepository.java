package apisistemaventa.apisistemaventa.repository;

import org.springframework.data.repository.CrudRepository;

import apisistemaventa.apisistemaventa.model.Producto;

public interface ProductoRepository extends CrudRepository <Producto, Long> {
    
}
