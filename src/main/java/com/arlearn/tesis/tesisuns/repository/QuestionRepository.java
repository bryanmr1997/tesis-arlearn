package com.arlearn.tesis.tesisuns.repository;



import com.arlearn.tesis.tesisuns.models.Questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Questions,Long> {
}
