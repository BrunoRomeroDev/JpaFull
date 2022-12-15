package com.ebookjpa.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "gerente")
@PrimaryKeyJoinColumn(name = "cargos_codigo")
public class Gerente extends Cargos {
	
	private String nome;
	private String setor;
	
	

}
