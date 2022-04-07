package br.com.zup.edu.umparamuitos3endereco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.edu.umparamuitos3endereco.model.Zupper;

@Repository
public interface ZupperRepository extends JpaRepository<Zupper, Long>{

}
