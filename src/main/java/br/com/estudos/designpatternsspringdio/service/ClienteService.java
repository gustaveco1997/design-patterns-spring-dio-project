package br.com.estudos.designpatternsspringdio.service;

import br.com.estudos.designpatternsspringdio.model.Cliente;

//Strategy
public interface ClienteService {
    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
