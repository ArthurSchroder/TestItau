package com.desafioItau.controller;

import com.desafioItau.controller.dto.TransacaoDTO;
import com.desafioItau.entities.Transacao;
import com.desafioItau.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> startTransaction(TransacaoDTO transacaoDTO) throws Exception {
        transacaoService.startTransaction(transacaoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteTransaction(){
        transacaoService.deleteAllTransactions();
        return new ResponseEntity(HttpStatus.OK);
    }
}
