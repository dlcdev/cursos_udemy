package com.example.curso.boot.service;

import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.domain.Departamento;

import java.util.List;

public interface DepartamentoService {

    void salvar(Departamento cargo);

    void editar(Departamento cargo);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscartodos();

    boolean departamentoTemCargos(Long id);

}
