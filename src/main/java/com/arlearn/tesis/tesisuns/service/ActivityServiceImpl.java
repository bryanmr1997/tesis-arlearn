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
public class ActivityServiceImpl implements IActivityService {



    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public List<Activities> listarActivity() {
        return activityRepository.findAll();
    }

    @Override
    public Activities registrarActivities(Activities body) {

        Long idCurso=body.getCourseId().getId();

//        System.out.println("x10 este es el valor del idExperience "+idExperience);
        Optional<Courses> responseCourse=courseRepository.findById(idCurso);

        System.out.println("x10 este es el valor de responseCurso"+  responseCourse);

        if (responseCourse.isPresent()) {
            System.out.println("x11 entro al if");
            Activities actividadRegistrada=new Activities(body.getName(), body.getDescription(),body.getCourseId(), "E");
            System.out.println("x11 fallo el registro"+actividadRegistrada);
            activityRepository.save(actividadRegistrada);

            System.out.println("x11 guardo el save");
            return actividadRegistrada;
        }


        return null;
    }



    @Override
    public String eliminar(Long idActivity) {
        Optional<Activities> encontrado=activityRepository.findById(idActivity);

        if(encontrado.isPresent()){

            Activities activityDisabled=encontrado.get();
            activityDisabled.setState("D");
            activityRepository.save(activityDisabled);
            return "Actividad deshabilitada";
        }

        return "No se encontro el id";
    }
}
