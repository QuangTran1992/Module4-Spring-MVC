//package com.codegym.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//
//
//@AllArgsConstructor
//@NoArgsConstructor
//@Data
//@Entity
//@Table(name = "transfer")
//public class Transfer {
//    @Id
//    @GeneratedValue(strategy =  GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "IdSender")
//    private Long id_sender;
//
//    @Column(name = "IdReceive")
//    private Long id_receive;
//
//    @Column(name = "amount")
//    private BigDecimal amount;
//
//    @Column(name = "fee")
//    private BigDecimal fee = new BigDecimal("5");
//
//    @Column(name = "fee_transaciton")
//    private BigDecimal fee_transaction;
//
//}
