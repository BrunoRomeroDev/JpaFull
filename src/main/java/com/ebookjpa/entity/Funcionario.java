package com.ebookjpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("F")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public class Funcionario extends Pessoa {
	
	@Column(nullable = true)
	private BigDecimal salario;
	
	@Column(length = 60, nullable = true)
	private String cargo;
	

}
