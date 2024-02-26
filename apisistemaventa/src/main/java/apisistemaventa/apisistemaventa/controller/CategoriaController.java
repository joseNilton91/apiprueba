package apisistemaventa.apisistemaventa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import apisistemaventa.apisistemaventa.model.Categoria;
import apisistemaventa.apisistemaventa.service.CategoriaService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private CategoriaService service;

     @Autowired
    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping("/listar")
    public Iterable<Categoria> listar() {
        return service.listar();
    }

    @GetMapping("/buscar/{id}")
    public Categoria buscar(@PathVariable long id) {
        return service.buscar(id);
    }

    @PostMapping("/agregar")
    public Categoria save(@Valid @RequestBody Categoria categoria) {
        return service.save(categoria);

    }

    @PutMapping("/modificar/{id}")
    public Categoria modificar(@RequestBody Categoria categoria, @PathVariable Long id) {
        Categoria categoriaExistente = service.buscar(id);
        if (categoriaExistente != null) {
            categoria.setIdCodigoCategoria(id);
            return service.save(categoria);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Categoria categoriaDelete = service.buscar(id);
        service.delete(categoriaDelete);
        return ResponseEntity.ok("Categoría eliminada correctamente.");
    }
}