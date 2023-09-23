package com.sii.service;

import com.sii.dto.TransactionsGeneratorDto;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;
import java.util.Random;

@Service
public class TransactionsGeneratorServiceImpl implements TransactionsGeneratorService{


    @Override
    public TransactionsGeneratorDto generateTransactions() {
        TransactionsGeneratorDto transactionsGeneratorDto=new TransactionsGeneratorDto();
        transactionsGeneratorDto.setActor("UserAccount "+ generateRandomNumber());
        transactionsGeneratorDto.setType("Transaction Type");
        transactionsGeneratorDto.setTimestamp(new Timestamp(System.currentTimeMillis()));
        transactionsGeneratorDto.setTransactionData( Map.of("Transaction Amount", generateRandomNumber()));
        return transactionsGeneratorDto;
    }
    private int generateRandomNumber(){
        int upperbound = 99;
       return new Random().nextInt(upperbound);
    }
}
