package br.com.estudos.designpatternsspringdio.model.repository;

import br.com.estudos.designpatternsspringdio.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
