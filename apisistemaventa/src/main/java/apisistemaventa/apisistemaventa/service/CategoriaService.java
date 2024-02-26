package apisistemaventa.apisistemaventa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apisistemaventa.apisistemaventa.inteface.ICategoria;
import apisistemaventa.apisistemaventa.model.Categoria;
import apisistemaventa.apisistemaventa.repository.CategoriaRepository;

@Service
public class CategoriaService implements ICategoria {

    private CategoriaRepository repository;

    @Autowired
    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Categoria> listar() {
        return repository.findAll();
    }

    @Override
    public Categoria buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        repository.delete(categoria);

    }
}