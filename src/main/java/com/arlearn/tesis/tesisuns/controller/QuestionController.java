package com.arlearn.tesis.tesisuns.controller;


import com.arlearn.tesis.tesisuns.models.Questions;
import com.arlearn.tesis.tesisuns.service.QuestionServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RestController
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionService;



    @GetMapping("/listar")

    public ResponseEntity <List<Questions>> listarPreguntas() {
        List<Questions> list=questionService.listarQuestion();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping("/registrar")

    public Questions registrarPreguntas(@RequestBody Questions body) {
        return questionService.registrarQuestions(body);
    }

//    @PutMapping("/actualizar/{id}")
//    public Experiences actualizar(@RequestBody Experiences body, @PathVariable("id") Long id) {
//        return experienceService.actualizar(body, id);
//    }

    @DeleteMapping("/deshabilitar/{id}")
    public String deshabilitar(@PathVariable("id") Long id) {
        return questionService.eliminar(id);
    }

}

