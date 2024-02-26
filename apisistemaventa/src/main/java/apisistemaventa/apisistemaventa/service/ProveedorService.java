package apisistemaventa.apisistemaventa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apisistemaventa.apisistemaventa.inteface.Iproveedor;
import apisistemaventa.apisistemaventa.model.Proveedor;
import apisistemaventa.apisistemaventa.repository.ProveedorRepository;

@Service
public class ProveedorService implements Iproveedor {

    private ProveedorRepository repository;

     @Autowired
    public ProveedorService(ProveedorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Proveedor> listar() {
        return repository.findAll();
    }

    @Override
    public Proveedor buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return repository.save(proveedor);
    }

    @Override
    public void delete(Proveedor proveedor) {
        repository.delete(proveedor);
    }

}
