package com.arlearn.tesis.tesisuns.service;


import com.arlearn.tesis.tesisuns.models.Courses;


import java.util.List;

public interface ICourseService {




    List<Courses> listarCourses();

    Courses buscarCurso(Long idCurso);

    Courses registrarCourses(Courses body);

    Courses actualizar(Courses body, Long id);

    String eliminar(Long idCourses);
}
