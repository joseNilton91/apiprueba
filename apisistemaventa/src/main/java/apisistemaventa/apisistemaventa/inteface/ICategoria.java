package apisistemaventa.apisistemaventa.inteface;

import apisistemaventa.apisistemaventa.model.Categoria;

public interface ICategoria {
    public Iterable<Categoria> listar();

    public Categoria buscar(Long id);

    public Categoria save(Categoria categoria);

    public void delete(Categoria categoria);
    
}
