package com.proj1spring.cadastro_receita.infrastructure.repository;

import com.proj1spring.cadastro_receita.infrastructure.entitys.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Integer> {
    List<Receita> findByNomeIgnoreCase(String nome);
}

