package apisistemaventa.apisistemaventa.inteface;

import apisistemaventa.apisistemaventa.model.Cliente;

public interface ICliente {
    public Iterable<Cliente> listar();

    public Cliente buscar(long id);

    public Cliente save(Cliente cliente);

    public void delete(Cliente cliente);

}
