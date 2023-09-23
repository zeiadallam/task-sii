package com.sii.service;

import com.sii.dto.TransactionsGeneratorDto;
import com.sii.model.Transaction;
import com.sii.repository.TransactionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {
    private TransactionsRepository transactionsRepository;
    private final WebClient.Builder webClientBuilder;

    @Override
    public void createTransactions() {
        Transaction transaction = new Transaction();
        TransactionsGeneratorDto transactionsGeneratorDto =
                webClientBuilder.build().get().uri("http://authentication-service:8083/api/trans-generator").
                        retrieve().bodyToMono(TransactionsGeneratorDto.class).block();
        transaction.setActor(transactionsGeneratorDto.getActor());
        transaction.setTimestamp(transactionsGeneratorDto.getTimestamp());
        transaction.setType(transactionsGeneratorDto.getType());
        transaction.setTransactionData(transactionsGeneratorDto.getTransactionData());
        transactionsRepository.save(transaction);

    }


    @Override
    public void updateTransactions(TransactionsGeneratorDto transactionsGeneratorDto) {
        Optional<Transaction> optionalTransaction = transactionsRepository.findById(transactionsGeneratorDto.getId());
        if (optionalTransaction.isPresent()) {
            Transaction transaction = new Transaction();
            transaction.setId(transactionsGeneratorDto.getId());
            transaction.setActor(transactionsGeneratorDto.getActor());
            transaction.setTimestamp(transactionsGeneratorDto.getTimestamp());
            transaction.setType(transactionsGeneratorDto.getType());
            transaction.setTransactionData(transactionsGeneratorDto.getTransactionData());
            transactionsRepository.save(transaction);
        } else {
            throw new RuntimeException("Transaction Not Found");
        }

    }

    @Override
    public void deleteTransactions(int transactionId) {
        transactionsRepository.deleteById(transactionId);
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        Optional<Transaction> optionalTransaction = transactionsRepository.findById(transactionId);
        return optionalTransaction.orElse(null);
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionsRepository.findAll();
    }
}
