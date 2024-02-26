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

import apisistemaventa.apisistemaventa.model.Producto;
import apisistemaventa.apisistemaventa.service.ProductoService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    private ProductoService service;

     @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public Iterable<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public Producto buscar(@PathVariable long id) {
        return service.buscar(id);
    }

    @PostMapping("/agregar")
    public Producto save(@RequestBody Producto producto) {
        return service.save(producto);
    }

    @PutMapping("/modificar{id}")
    public Producto modificar(@RequestBody Producto producto, @PathVariable long id) {
        Producto productoExistente = service.buscar(id);

        if (productoExistente != null) {
            producto.setIdCodigoProducto(id);
            return service.save(producto);

        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        Producto productoDelete = service.buscar(id);
        service.delete(productoDelete);
        try {
            return ResponseEntity.ok("Producto eliminado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.ok("El Producto no puede ser eliminado.");
        }

    }
}
