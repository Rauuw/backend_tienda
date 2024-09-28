package com.example.back.controllers;

import com.example.back.clases.Productos;
import com.example.back.repositorys.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository pr;

    @GetMapping
    public List<Productos> getAll() {
        return pr.findAll();
    }

    @GetMapping("/{id}")
    public Productos get(@PathVariable int id) {
        return pr.findById(id).orElse(null);
    }

    @PostMapping()
    public void create(@RequestPart("producto") Productos p, @RequestPart("file") MultipartFile imagen) {
        System.out.println("PASA POR AQUI 1");
        if (imagen != null && !imagen.isEmpty()) {
            String fileName = imagen.getOriginalFilename();
            String filePath = "src/main/resources/static/imagenes/" + fileName;
            System.out.println("PASA POR AQUI");
            try {
                Path uploadPath = Paths.get(filePath);
                Files.copy(imagen.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                p.setImagen(filePath);
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar la imagen", e);
            }
        }
        pr.save(p);
        System.out.println("Producto creado " + p.toString());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id,@RequestBody Productos p) {
        Productos producto = pr.findById(id).orElse(null);
        if (producto != null) {
            producto.setNombre(p.getNombre());
            producto.setMarca(p.getMarca());
            producto.setColor(p.getColor());
            producto.setStock(p.getStock());
            producto.setPrecio_compra(p.getPrecio_compra());
            producto.setPrecio_comercial(p.getPrecio_comercial());
            pr.save(producto);
        }else {
            System.out.println("Error al actualizar");
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        pr.deleteById(id);
        System.out.println("Eliminado correctamente");
    }

    @GetMapping("/imagen/{id}")
    public ResponseEntity<ByteArrayResource> getImagen(@PathVariable int id) {
        Productos p = pr.findById(id).orElse(null);

        if (p != null) {
            try {
                byte[] imageData = Files.readAllBytes(Paths.get(p.getImagen()));
                ByteArrayResource resource = new ByteArrayResource(imageData);

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + p.getImagen() + "\"")
                        .contentType(MediaType.IMAGE_PNG) // Cambia según el tipo de imagen
                        .body(resource);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/hola_mundo")
    public String holaMundo() {
        return "Hola Mundo";
    }
}
