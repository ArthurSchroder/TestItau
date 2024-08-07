package com.desafioItau.service;

import com.desafioItau.controller.dto.TransacaoDTO;
import com.desafioItau.entities.Estatistica;
import com.desafioItau.entities.Transacao;
import com.desafioItau.repository.EstatisticaRepository;
import com.desafioItau.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Service
public class TransacaoService {
    @Autowired
    TransacaoRepository transacaoRepository;

    @Autowired
    EstatisticaRepository estatisticaRepository;

    public Transacao startTransaction(TransacaoDTO transacaoDTO) throws Exception {
        Transacao transacao = new Transacao(transacaoDTO);
        if (transacao.dataHora.isAfter(OffsetDateTime.now())){
            throw new Exception(Un);
        }
        if (transacao.valor.equals(0)){
            throw new Exception("422");
        }
        transacaoRepository.save(transacao);
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime minuteBefore = now.minusMinutes(1);
        if (transacao.dataHora.isAfter(minuteBefore)){
            Estatistica estatistica = new Estatistica();

            estatistica.setCount(BigDecimal.valueOf(1));
            estatisticaRepository.save(estatistica);
        }

        return transacao;
    }

    public List<Transacao> getAllTransactions(){
        return transacaoRepository.findAll();
    }

    public void deleteAllTransactions() {
        transacaoRepository.deleteAll();
    }
}
