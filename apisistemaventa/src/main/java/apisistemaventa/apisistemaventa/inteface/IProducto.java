package apisistemaventa.apisistemaventa.inteface;

import apisistemaventa.apisistemaventa.model.Producto;

public interface IProducto {
    public Iterable<Producto> listar();

    public Producto buscar(long id);

    public Producto save(Producto producto);

    public void delete(Producto producto);
}
