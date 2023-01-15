package com.example.curso.boot.dao;

import com.example.curso.boot.domain.Cargo;
import com.example.curso.boot.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CargoDao extends JpaRepository<Cargo, Long> {

}
