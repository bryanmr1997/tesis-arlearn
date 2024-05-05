package com.arlearn.tesis.tesisuns.repository;


import com.arlearn.tesis.tesisuns.models.Courses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Long> {
}
