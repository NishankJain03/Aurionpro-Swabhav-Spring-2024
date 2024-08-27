package com.aurionpro.document.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;

import com.aurionpro.document.dto.ImageModel;

public interface ImageService {
	ResponseEntity<Map> uploadImage(ImageModel imageModel);
}
