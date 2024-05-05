package com.arlearn.tesis.tesisuns.service;


import com.arlearn.tesis.tesisuns.models.Activities;
import com.arlearn.tesis.tesisuns.models.Courses;


import java.util.List;

public interface IActivityService {




    List<Activities> listarActivity();

    Activities registrarActivities(Activities body);



//    Experiences actualizar(Experiences body, Long id);

    String eliminar(Long idActivity);
}
