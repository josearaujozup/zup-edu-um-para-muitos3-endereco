package br.com.zup.edu.umparamuitos3endereco.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos3endereco.model.Endereco;
import br.com.zup.edu.umparamuitos3endereco.model.Zupper;
import br.com.zup.edu.umparamuitos3endereco.repository.EnderecoRepository;
import br.com.zup.edu.umparamuitos3endereco.repository.ZupperRepository;

@RestController
public class EnderecoController {
	
	@Autowired
	ZupperRepository zupperRepository;
	
	@Autowired
	EnderecoRepository repository;
	
	@Transactional
	@PostMapping("/api/zuppers/{idZupper}/enderecos")
	ResponseEntity<?> cadastrar(@PathVariable Long idZupper, @RequestBody @Valid EnderecoDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		Zupper zupper = zupperRepository.findById(idZupper).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe cadastro de zupper para o id informado"));
		
		Endereco endereco = request.toModel(zupper);
		repository.save(endereco);
		
		zupperRepository.save(zupper);
		
		URI location = uriComponentsBuilder.path("/api/zuppers/{idZupper}/enderecos/{id}").buildAndExpand(zupper.getId(),endereco.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
		
}
