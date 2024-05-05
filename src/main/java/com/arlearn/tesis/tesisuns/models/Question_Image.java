package com.arlearn.tesis.tesisuns.models;

import javax.persistence.*;

@Entity
public class Question_Image {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "questionId",referencedColumnName = "id")
    private  Questions questionId;

    @ManyToOne
    @JoinColumn(name = "arimageId",referencedColumnName = "id")
    private ArImages arimageId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public ArImages getArimageId() {
        return arimageId;
    }

    public void setArimageId(ArImages arimageId) {
        this.arimageId = arimageId;
    }

    public Question_Image() {
    }


    public Question_Image(Questions questionId, ArImages arimageId) {
        this.questionId = questionId;
        this.arimageId = arimageId;
    }
}
