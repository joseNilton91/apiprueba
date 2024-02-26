package apisistemaventa.apisistemaventa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apisistemaventa.apisistemaventa.model.Cliente;
import apisistemaventa.apisistemaventa.service.ClienteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService service;

     @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public Iterable<Cliente> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public Cliente buscar(@PathVariable long id) {
        return service.buscar(id);

    }

    @PostMapping("/agregar")
    public Cliente agregar(@Valid @RequestBody Cliente cliente) {
        return service.save(cliente);
    }

    @PutMapping("/modificar/{id}")
    public Cliente modificar(@RequestBody Cliente cliente, @PathVariable long id) {
        Cliente clienteExistente = service.buscar(id);
        if (clienteExistente != null) {
            cliente.setIdRutCliente(id);
            return service.save(cliente);

        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Cliente clienteDelete = service.buscar(id);
        service.delete(clienteDelete);
        return ResponseEntity.ok("Cliente eliminado correctamente.");
    }

}