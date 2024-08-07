package com.desafioItau.repository;

import com.desafioItau.entities.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}
