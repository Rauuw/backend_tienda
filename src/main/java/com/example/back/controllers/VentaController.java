package com.example.back.controllers;

import com.example.back.clases.Ventas;
import com.example.back.repositorys.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaRepository vr;


    @GetMapping
    public List<Ventas> getAll() {
        return vr.findAll();
    }

    @GetMapping("/{id}")
    public Ventas get(@PathVariable int id) {
        return vr.findById(1).orElse(null);
    }

    @PostMapping
    public void create(@RequestPart("venta") Ventas v,@RequestPart("file") MultipartFile imagen) {
        System.out.println("PASA POR AQUI 1");
        if (imagen != null && !imagen.isEmpty()) {
            String fileName = imagen.getOriginalFilename();
            String filePath = "src/main/resources/static/imagenes/" + fileName;
            System.out.println("PASA POR AQUI");
            try {
                Path uploadPath = Paths.get(filePath);
                Files.copy(imagen.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
                v.setImagen(filePath);
            } catch (IOException e) {
                throw new RuntimeException("Error al guardar la imagen", e);
            }
        }
        vr.save(v);
        System.out.println("Producto creado " + v.toString());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        vr.deleteById(id);
        System.out.println("Eliminado correctamente");
    }
}



