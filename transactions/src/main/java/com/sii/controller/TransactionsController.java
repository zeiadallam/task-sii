package com.sii.controller;

import com.sii.dto.TransactionsGeneratorDto;
import com.sii.model.Transaction;
import com.sii.service.TransactionsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/transactions/")
@AllArgsConstructor
@RestController
public class TransactionsController {
    private TransactionsService transactionsService;

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createTransactions() {
        transactionsService.createTransactions();
    }

    @DeleteMapping("/delete/{transactionId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTransactions(@PathVariable int transactionId) {
        transactionsService.deleteTransactions(transactionId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Transaction>> deleteTransactions() {
        return ResponseEntity.ok(transactionsService.getTransactions());
    }

    @GetMapping("/get-transaction/{transactionId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Transaction> getTransactionById(@PathVariable int transactionId) {
        return ResponseEntity.ok(transactionsService.getTransactionById(transactionId));
    }

    @PatchMapping("/update-transaction/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTransaction(@RequestBody TransactionsGeneratorDto transactionsGeneratorDto) {
        transactionsService.updateTransactions(transactionsGeneratorDto);
    }

}