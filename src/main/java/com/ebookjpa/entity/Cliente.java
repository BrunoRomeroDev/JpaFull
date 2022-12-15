package com.ebookjpa.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@DiscriminatorValue("C")
public class Cliente extends Pessoa {
	
	@Column(name = "limite_credito", nullable = true)
	private BigDecimal limiteCredito;
	
	@Column(name = "renda_mensal", nullable = true)
	private BigDecimal rendaMensal;
	
	@Column(nullable = true)
	private boolean bloqueado;

}
