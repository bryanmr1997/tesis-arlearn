package com.arlearn.tesis.tesisuns.service;




import com.arlearn.tesis.tesisuns.models.Questions;


import java.util.List;

public interface IQuestionService {




    List<Questions> listarQuestion();

    Questions registrarQuestions(Questions body);

//    Experiences actualizar(Experiences body, Long id);

    String eliminar(Long idQuestion);
}
