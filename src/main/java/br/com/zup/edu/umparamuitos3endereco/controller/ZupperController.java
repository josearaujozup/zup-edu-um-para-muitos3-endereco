package br.com.zup.edu.umparamuitos3endereco.controller;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.edu.umparamuitos3endereco.model.Zupper;
import br.com.zup.edu.umparamuitos3endereco.repository.ZupperRepository;

@RestController
public class ZupperController {
	
	@Autowired
	ZupperRepository repository;
	
	@Transactional
	@PostMapping("/api/zuppers")
	ResponseEntity<?> cadastrar(@RequestBody @Valid ZupperDTO request, UriComponentsBuilder uriComponentsBuilder){
		
		
		Zupper zupper = request.toModel();
		repository.save(zupper);
		
		URI location = uriComponentsBuilder.path("/api/zuppers/{id}").buildAndExpand(zupper.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
