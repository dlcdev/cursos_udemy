package com.example.clients.model.repository;

import com.example.clients.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
