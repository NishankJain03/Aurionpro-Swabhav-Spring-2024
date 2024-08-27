package com.aurionpro.document.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class Image {
	
	@Column(name = "docId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int docId;
	
	@Column(name = "name_image")
    private String name;

    @Column(name = "url")
    private String url;
}
