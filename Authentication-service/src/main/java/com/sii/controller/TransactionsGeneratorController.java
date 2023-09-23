package com.sii.controller;

import com.sii.dto.TransactionsGeneratorDto;
import com.sii.service.TransactionsGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@AllArgsConstructor
@RestController
public class TransactionsGeneratorController {
    private TransactionsGeneratorService transactionsGeneratorService;

    @GetMapping("/trans-generator")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<TransactionsGeneratorDto> generateTransactions() {
        return ResponseEntity.ok().body(transactionsGeneratorService.generateTransactions());
    }

}