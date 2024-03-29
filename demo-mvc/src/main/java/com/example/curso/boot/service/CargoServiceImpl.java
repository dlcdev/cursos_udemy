package com.example.curso.boot.service;

import com.example.curso.boot.dao.CargoDao;
import com.example.curso.boot.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao dao;


    @Override
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    public void excluir(Long id) {
        dao.deleteById(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        Cargo byId = dao.findById(id).get();
        return byId;
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscartodos() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionarios(Long id) {
        if(buscarPorId(id).getFuncionarios().isEmpty()) {
            return false;
        }
        return true;
    }
}
