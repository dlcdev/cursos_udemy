package com.example.curso.boot.dao;

import com.example.curso.boot.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioDaorepo extends JpaRepository<Funcionario, Long> {

    @Query("SELECT fun from Funcionario fun where fun.nome like concat('%', ?1, '%')")
    List<Funcionario> findByNomeIsLike(String nome);

    @Query("SELECT fun from Funcionario fun where fun.cargo.id = ?1")
    List<Funcionario> findByCargoIsLike(Long id);
}
