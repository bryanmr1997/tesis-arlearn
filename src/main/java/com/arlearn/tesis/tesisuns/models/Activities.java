package com.arlearn.tesis.tesisuns.models;



import javax.persistence.*;

@Entity
public class Activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    private String description;


    private String state;



    @ManyToOne
    @JoinColumn(name = "courseId")
    private Courses courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Courses getCourseId() {
        return courseId;
    }

    public void setExperienceId(Courses courseId) {
        this.courseId = courseId;
    }

    public Activities() {
    }

    public Activities(String name, String description, Courses courseId ,String state) {
        this.name = name;
        this.description = description;

        this.courseId = courseId;
        this.state = state;
    }


}
