package com.example.curso.boot.service;

import com.example.curso.boot.dao.FuncionarioDaorepo;
import com.example.curso.boot.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class FuncionarioImpl implements FuncionarioService {

    @Autowired
    FuncionarioDaorepo dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);

    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id).get();
    }

    @Override
    public List<Funcionario> buscartodos() {
        return dao.findAll();
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNomeIsLike(nome);
    }

    @Override
    public List<Funcionario> buscarPorCargo(Long id) {
        return dao.findByCargoIsLike(id);
    }
}
