package br.com.zup.edu.umparamuitos3endereco.controller;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.edu.umparamuitos3endereco.model.Cargo;
import br.com.zup.edu.umparamuitos3endereco.model.Zupper;

public class ZupperDTO {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String email;
	
	@NotNull
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

	public ZupperDTO(@NotBlank String nome, @NotBlank String email, @NotNull Cargo cargo) {
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
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

	public Zupper toModel() {
		return new Zupper(nome,email,cargo);
	}
	
}
