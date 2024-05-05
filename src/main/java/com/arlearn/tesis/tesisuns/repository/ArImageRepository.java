package com.arlearn.tesis.tesisuns.repository;


import com.arlearn.tesis.tesisuns.models.ArImages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArImageRepository extends JpaRepository<ArImages,Long> {
}
