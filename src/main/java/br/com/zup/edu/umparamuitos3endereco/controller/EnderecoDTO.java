package br.com.zup.edu.umparamuitos3endereco.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.edu.umparamuitos3endereco.model.Endereco;
import br.com.zup.edu.umparamuitos3endereco.model.Zupper;

public class EnderecoDTO {
	
	@NotBlank
	private String logradouro;
	
	@NotNull
	private Integer numero;
	
	@NotBlank
	private String bairro;
	
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotBlank
	private String estado;
	
	@NotBlank
	private String cep;

	public EnderecoDTO(String logradouro, Integer numero, String bairro, String complemento, String cidade,
			String estado, String cep) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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

	public Endereco toModel(Zupper zupper) {
		Endereco endereco = new Endereco(logradouro, numero, bairro, complemento, cidade, estado, cep);
		zupper.getEnderecos().add(endereco);
		endereco.setZupper(zupper);
		return endereco;
	}

	
}
