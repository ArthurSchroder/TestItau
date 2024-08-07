package com.desafioItau.repository;

import com.desafioItau.entities.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query("SELECT t FROM Transacao t WHERE t.dataHora >= :minuto")
    List<Transacao> findLastMinuteTransaction(@Param("minuto")OffsetDateTime minuto);
}
