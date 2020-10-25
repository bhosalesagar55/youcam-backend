package com.youcam.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youcam.backend.model.ImageFile;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, String> {

}
