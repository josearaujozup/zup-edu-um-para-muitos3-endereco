package br.com.zup.edu.umparamuitos3endereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String bairro;
	
	private String complemento;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String cep;
	
	@ManyToOne
	private Zupper zupper;

	public Endereco(String logradouro, Integer numero, String bairro, String complemento, String cidade, String estado,
			String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
    public Endereco() {
    	
    }

	public Long getId() {
		return id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getBairro() {
		return bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getCep() {
		return cep;
	}

	public void setZupper(Zupper zupper) {
		this.zupper = zupper;
	}
	
}
