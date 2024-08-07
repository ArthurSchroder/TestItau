package com.desafioItau.service;

import com.desafioItau.entities.Estatistica;
import com.desafioItau.entities.Transacao;
import com.desafioItau.repository.EstatisticaRepository;
import com.desafioItau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class EstatisticaService {

    @Autowired
    EstatisticaRepository estatisticaRepository;

    @Autowired
    TransacaoRepository transacaoRepository;

    public Estatistica findAllStatistics() {
        Estatistica estatistica = new Estatistica();
//        List<Transacao> transacoes = transacaoRepository.findAll();
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime minuto = agora.minusSeconds(60L);
//        List<Transacao> transacoesValidas = transacoes.stream().filter(transacao -> transacao.getDataHora().isAfter(minuto)).toList();
        List<Transacao> transacoesValidas = transacaoRepository.findLastMinuteTransaction(minuto);
        estatistica.setCount(BigDecimal.valueOf(transacoesValidas.size()));
        estatistica.setSum(transacoesValidas.stream().map(Transacao::getValor).reduce(BigDecimal.ZERO, BigDecimal::add));
        estatistica.setAvg(estatistica.getSum().divide(estatistica.getCount()));
        estatistica.setMin(transacoesValidas.stream().map(Transacao::getValor).min(Comparator.naturalOrder()).orElse(BigDecimal.ZERO));
        estatistica.setMax(transacoesValidas.stream().map(Transacao::getValor).max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO));
        return estatistica;
    }


}
