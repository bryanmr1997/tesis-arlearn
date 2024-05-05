package com.arlearn.tesis.tesisuns.service;



import com.arlearn.tesis.tesisuns.models.Activities;
import com.arlearn.tesis.tesisuns.models.Courses;
import com.arlearn.tesis.tesisuns.repository.ActivityRepository;
import com.arlearn.tesis.tesisuns.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List<Courses> listarCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Courses buscarCurso(Long idCurso) {

        return courseRepository.findById(idCurso).orElse(null);
    }

    @Override
    public Courses registrarCourses(Courses body) {
        Courses nuevo=new Courses(body.getName(), body.getDescription(), "E");

        return courseRepository.save(nuevo);
    }

    @Override
    public Courses actualizar(Courses body, Long id) {

        Optional<Courses> courses=courseRepository.findById(id);
        if(courses.isPresent()){
            Courses coursesActualizado=courses.get();

            coursesActualizado.setName(body.getName());
            coursesActualizado.setDescription(body.getDescription());

            courseRepository.save(coursesActualizado);
        }
        return null;
    }

    @Override
    public String eliminar(Long idCourses) {

        Optional<Courses> encontrado=courseRepository.findById(idCourses);

        if(encontrado.isPresent()){

                Courses courseDisabled=encontrado.get();
                courseDisabled.setState("D");
                courseRepository.save(courseDisabled);


            // Deshabilitar automáticamente las actividades relacionadas
            List<Activities> relatedActivities = activityRepository.findByCourseId(courseDisabled);
            for (Activities activity : relatedActivities) {
                activity.setState("D");
                activityRepository.save(activity);
            }


                return "Curso deshabilitado";
        }

        return "No se encontro el id";
    }


}
