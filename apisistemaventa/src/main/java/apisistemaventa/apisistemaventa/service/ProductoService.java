package apisistemaventa.apisistemaventa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apisistemaventa.apisistemaventa.inteface.IProducto;
import apisistemaventa.apisistemaventa.model.Producto;
import apisistemaventa.apisistemaventa.repository.ProductoRepository;

@Service
public class ProductoService implements IProducto {

    private ProductoRepository repository;

     @Autowired
    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Producto> listar() {
        return repository.findAll();
    }

    @Override
    public Producto buscar(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public void delete(Producto producto) {
        repository.delete(producto);
    }
}