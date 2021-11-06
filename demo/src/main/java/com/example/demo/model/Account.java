package com.example.demo.model;

import javax.persistence.*;
import com.example.demo.model.Customer;

@Entity
@Table(name="account")
public class Account {


//    private Integer accountId;
//    private String accountType; // oni na
//    private String Owner;   // owner = customer
//    private String valueAmount;
//    private String InsuranceType;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="accountId")
    private Integer accountId;

    @ManyToOne
    @JoinColumn(name="cusId")
    private Customer customer ;

    @ManyToOne
    @JoinColumn(name="categoryid")
    private Category category ;

    // owner = customer
    private String valueAmount;
    private String InsuranceType;


    public String getInsuranceType() {
        return InsuranceType;
    }

//    public Integer getAccountId() {
//        return accountId;
//    }
//
//    public String getAccountType() {
//        return accountType;
//    }
//
//    public String getOwner() {
//        return Owner;
//    }
//
//    public String getValueAmount() {
//        return valueAmount;
//    }
//
//    public void setAccountId(Integer accountId) {
//        this.accountId = accountId;
//    }
//
//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }
//
//    public void setOwner(String owner) {
//        Owner = owner;
//    }
//
//    public void setValueAmount(String valueAmount) {
//        this.valueAmount = valueAmount;
//    }
//
//    public void setInsuranceType(String insuranceType) {
//        InsuranceType = insuranceType;
//    }


    public Customer getCustomer() {
        return customer;
    }



    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getAccountId() {
        return accountId;
    }



    public String getValueAmount() {
        return valueAmount;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }



    public void setValueAmount(String valueAmount) {
        this.valueAmount = valueAmount;
    }

    public void setInsuranceType(String insuranceType) {
        InsuranceType = insuranceType;
    }

    public void assignCustomer(Customer customer) {
        this.customer=customer;
    }

    public void assignCategory(Category category) {
    }
}

