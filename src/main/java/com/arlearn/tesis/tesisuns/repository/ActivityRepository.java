package com.arlearn.tesis.tesisuns.repository;


import com.arlearn.tesis.tesisuns.models.Activities;

import com.arlearn.tesis.tesisuns.models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activities,Long> {

    List<Activities> findByCourseId(Courses course);
}
