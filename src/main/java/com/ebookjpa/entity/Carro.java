package com.ebookjpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Carro {
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc",strategy = "increment")
	private Long codigo;
	
	private String cor;
	private String modelo;
	private Integer ano;

}
