package com.example.curso.boot.service;

import com.example.curso.boot.dao.DepartamentoRepo;
import com.example.curso.boot.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepo repo;

    @Transactional(readOnly = false)
    @Override
    public void salvar(Departamento departamento) {
        repo.save(departamento);
    }

    @Transactional(readOnly = false)
    @Override
    public void editar(Departamento departamento) {
        repo.save(departamento);
    }

    public void excluir(Long id) {
        Departamento departamento = repo.findById(id).get();
        repo.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Departamento buscarPorId(Long id) {
        return repo.findById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> buscartodos() {
        return repo.findAll();
    }

    @Override
    public boolean departamentoTemCargos(Long id) {
        if (buscarPorId(id).getCargos().isEmpty()) {
            return false;
        }
        return true;
    }
}
