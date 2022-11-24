package com.example.clients.res;

import com.example.clients.model.entity.Cliente;
import com.example.clients.model.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/api/clientes")
public class ClientController {

    private final ClienteRepository repository;

    public ClientController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente savar(@Valid @RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @GetMapping("/{id}")
    @ResponseStatus
    public Cliente obterPorId(@Valid @PathVariable Integer id) {
        return getCliente(id);
    }

    private Cliente getCliente(Integer id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(NOT_FOUND, "cliente não encontrado")
                );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        Cliente cliente = getCliente(id);
        repository.delete(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateCliente(@PathVariable final Integer id, @RequestBody Cliente clienteAtualizado) {
        Cliente cliente = getCliente(id);
        clienteAtualizado.setId(cliente.getId());
        repository.save(clienteAtualizado);
    }
}
