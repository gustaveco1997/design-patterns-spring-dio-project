package br.com.estudos.designpatternsspringdio.model.repository;

import br.com.estudos.designpatternsspringdio.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {
}
