package com.aurionpro.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.document.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer>{

}
