package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cusId")
    private Integer cusId;
    private String name;
    private String address;
    private String phoneNo;

    @JsonIgnore
    @OneToMany(targetEntity = Account.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "cusId",referencedColumnName = "cusId")
    private Set<Account> accounts;

//    private String accId;
//    private String accType;


//    public String getAccType() {
//        return accType;
//    }
//
//    public void setAccType(String accType) {
//        this.accType = accType;
//    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getCusId() {
        return cusId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

//    public String getAccId() {
//        return accId;
//    }
//
//    public void setCusId(Integer cusId) {
//        this.cusId = cusId;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

//    public void setAccId(String accId) {
//        this.accId = accId;
//    }
}
