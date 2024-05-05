package com.arlearn.tesis.tesisuns.controller;


import com.arlearn.tesis.tesisuns.models.Courses;
import com.arlearn.tesis.tesisuns.service.CourseServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;



    @GetMapping("/listar")

    public ResponseEntity <List<Courses>> listarCursos() {
        List<Courses> list=courseService.listarCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public Courses buscarCurso(@PathVariable("id") Long idCurso) {

        return courseService.buscarCurso(idCurso);
    }

    @PostMapping("/registrar")

    public Courses registrarCursos(@RequestBody Courses body) {
        return courseService.registrarCourses(body);
    }

    @PutMapping("/actualizar/{id}")

    public Courses actualizar(@RequestBody Courses body, @PathVariable("id") Long id) {
        return courseService.actualizar(body, id);
    }

    @DeleteMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Long id) {
        return courseService.eliminar(id);
    }



}

