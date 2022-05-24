package br.com.estudos.designpatternsspringdio.service.impl;

import br.com.estudos.designpatternsspringdio.model.Cliente;
import br.com.estudos.designpatternsspringdio.model.Endereco;
import br.com.estudos.designpatternsspringdio.model.repository.ClienteRepository;
import br.com.estudos.designpatternsspringdio.model.repository.EnderecoRepository;
import br.com.estudos.designpatternsspringdio.service.ClienteService;
import br.com.estudos.designpatternsspringdio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteDB = repository.findById(id);
        clienteDB.ifPresent((client) -> {
            salvarComCep(cliente);
        });
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private void salvarComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            return enderecoRepository.save(novoEndereco);
        });

        cliente.setEndereco(endereco);
        repository.save(cliente);
    }
}
