package com.sii.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Timestamp timestamp;
    private String type;
    private String actor;
    @ElementCollection
    @MapKeyColumn(name="amount")
    @Column(name="transaction_amount")
    @CollectionTable(name="transaction_data", joinColumns=@JoinColumn(name="transaction_id"))
    Map<String, Integer> transactionData ;

}
