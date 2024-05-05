package com.arlearn.tesis.tesisuns.service;





import com.arlearn.tesis.tesisuns.models.Questions;
import com.arlearn.tesis.tesisuns.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements IQuestionService {



    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public List<Questions> listarQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Questions registrarQuestions(Questions body) {

        Questions preguntaRegistrada=new Questions(body.getStatement(), body.getDescription(), body.getScore(),body.getArchivo(), "E");

        questionRepository.save(preguntaRegistrada);
        return preguntaRegistrada;

    }

    @Override
    public String eliminar(Long idQuestion) {
        Optional<Questions> encontrado=questionRepository.findById(idQuestion);

        if(encontrado.isPresent()){

            Questions questionsDisabled=encontrado.get();
            questionsDisabled.setState("D");
            questionRepository.save(questionsDisabled);
            return "Question deshabilitada";
        }

        return "No se encontró el id";
    }
}
