package br.com.zup.edu.umparamuitos3endereco.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.edu.umparamuitos3endereco.controller.EnderecoDTO;

@Entity
public class Zupper {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "zupper")
	private List<Endereco> enderecos = new ArrayList<>();

	public Zupper(String nome, String email, Cargo cargo) {
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
	}
	
	/**
     * @deprecated  construtor para uso exclusivo do Hibernate
     */
    @Deprecated
	public Zupper() {
		
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	
}
