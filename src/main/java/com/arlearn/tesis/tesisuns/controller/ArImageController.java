package com.arlearn.tesis.tesisuns.controller;


import com.arlearn.tesis.tesisuns.models.ArImages;
import com.arlearn.tesis.tesisuns.service.ArImagesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/images")
@RestController
public class ArImageController {

    @Autowired
    ArImagesServiceImpl arImagesService;



    @GetMapping("/listar")

    public ResponseEntity <List<ArImages>> listarImagen() {
        List<ArImages> list=arImagesService.listarImages();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping("/registrar")

    public ArImages registrarImagenes(@RequestBody ArImages body) {
        return arImagesService.registrarImages(body);
    }

    @PutMapping("/actualizar/{id}")
    public ArImages actualizar(@RequestBody ArImages body, @PathVariable("id") Long id) {
        return arImagesService.actualizar(body, id);
    }

    @DeleteMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Long id) {
        return arImagesService.eliminar(id);
    }

}

