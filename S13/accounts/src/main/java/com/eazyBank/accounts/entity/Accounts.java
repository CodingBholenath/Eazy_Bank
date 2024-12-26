package com.eazyBank.accounts.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString @AllArgsConstructor@NoArgsConstructor
public class Accounts extends
BaseEntity{

    private  Long customerId;
@Id
    private Long accountNumber;
@Column(name="account_type")
    private String accountType;
@Column(name="branch_address")
    private String branchAddress;
@Column(name="commuication_sw")
    private Boolean commuicationSw;



}

