package apisistemaventa.apisistemaventa.inteface;

import apisistemaventa.apisistemaventa.model.Proveedor;

public interface Iproveedor {
    
    public Iterable<Proveedor> listar();

    public Proveedor buscar(Long id);

    public Proveedor save(Proveedor proveedor); // guardar/modificar

    public void delete(Proveedor proveedor);
}
