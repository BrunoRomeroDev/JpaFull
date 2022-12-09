package com.ebookjpa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VeiculoId implements Serializable {
	private static final long serialVersionUID = 1L;


	private String placa;
	private String cidade;


}
