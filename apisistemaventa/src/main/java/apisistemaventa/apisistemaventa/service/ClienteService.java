package apisistemaventa.apisistemaventa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apisistemaventa.apisistemaventa.inteface.ICliente;
import apisistemaventa.apisistemaventa.model.Cliente;
import apisistemaventa.apisistemaventa.repository.ClienteRepository;

@Service
public class ClienteService implements ICliente {

    private ClienteRepository repository;

     @Autowired
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Cliente> listar() {
        return repository.findAll();
    }

    @Override
    public Cliente buscar(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        repository.delete(cliente);
    }
}