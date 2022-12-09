package com.ebookjpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tab_veiculo")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60, nullable = false)
	private String fabricante;
	@Column(length = 60, nullable = false)
	private String modelo;
	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabricacao;
	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModelo;
	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;
	
	@Embedded
	private VeiculoId codigo;


}
