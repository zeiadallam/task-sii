package com.sii.dto;


import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;


@Data
public class TransactionsGeneratorDto {

    private int id;
    private Timestamp timestamp;
    private String type;
    private String actor;
    Map<String, Integer> transactionData;
}
