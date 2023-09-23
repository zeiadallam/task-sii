package com.sii.dto;



import java.sql.Timestamp;
import lombok.Data;

import java.util.Map;


@Data
public class TransactionsGeneratorDto {

    private int id;
    private Timestamp timestamp;
    private String type;
    private String actor;
    Map<String,Integer> transactionData;
}
