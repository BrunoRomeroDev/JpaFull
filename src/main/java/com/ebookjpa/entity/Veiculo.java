package com.ebookjpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

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
	
	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Lob
	private byte[] foto;
	
	@Lob
	private String especificacoes;
	
	//atributo sera ignorado pelo hibernate na persistencia
	@Transient
	private String descricaoCompleta;

	
	@OneToOne //(optional = false) = obriga valor do proprietario
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;

	@ManyToOne
	@JoinColumn(name = "cod_condutor")
	private Condutores condutores;
	
	
	@ManyToMany
	@JoinTable(name = "veiculo_acessorio",
		joinColumns = @JoinColumn(name = "veiculo_codigo"),
		inverseJoinColumns = @JoinColumn(name = "acessorio_codigo"))
	private Set<Acessorios> acessorios = new HashSet<>();

}
