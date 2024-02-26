package apisistemaventa.apisistemaventa.repository;

import org.springframework.data.repository.CrudRepository;

import apisistemaventa.apisistemaventa.model.Cliente;

public interface ClienteRepository extends CrudRepository <Cliente, Long> {
    
}
