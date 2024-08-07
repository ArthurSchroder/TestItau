package com.desafioItau.controller;

import com.desafioItau.entities.Estatistica;
import com.desafioItau.service.EstatisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estatistica")
public class EstatisticaController {

    @Autowired
    EstatisticaService estatisticaService;

    @GetMapping
    public ResponseEntity<Estatistica> getStatistics(){
        Estatistica statistics = estatisticaService.findAllStatistics();
        return ResponseEntity.ok(statistics);
    }
}
