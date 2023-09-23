package com.sii.service;

import com.sii.dto.TransactionsGeneratorDto;
import com.sii.model.Transaction;

import java.util.List;

public interface TransactionsService {
    void createTransactions();
    void updateTransactions(TransactionsGeneratorDto transactionsGeneratorDto);
    void deleteTransactions(int transactionId);
    Transaction getTransactionById(int transactionId);
    List<Transaction> getTransactions();
}
