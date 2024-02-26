package apisistemaventa.apisistemaventa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import apisistemaventa.apisistemaventa.model.Proveedor;
import apisistemaventa.apisistemaventa.service.ProveedorService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/proveedor")

public class ProveedorController {

    private ProveedorService service;

     @Autowired
    public ProveedorController(ProveedorService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public Iterable<Proveedor> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public Proveedor buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @PostMapping("/agregar")

    public Proveedor agregar(@Valid @RequestBody Proveedor proveedor) {
        return service.save(proveedor);
    }

    @PutMapping("/modificar/{id}")
    public Proveedor modificar(@RequestBody Proveedor proveedor, @PathVariable Long id) {
        Proveedor proveedorExistente = service.buscar(id);
        if (proveedorExistente != null) {
            proveedor.setIdRutProveedor(id);
            return service.save(proveedor);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void delete(@PathVariable Long id) {
        Proveedor proveedorDelete = service.buscar(id);
        service.delete(proveedorDelete);
    }
}