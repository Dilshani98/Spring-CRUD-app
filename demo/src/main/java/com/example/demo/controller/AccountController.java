package com.example.demo.controller;

import com.example.demo.Pojos.AccountRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountRepository accRepo;

    @Autowired
    private CustomerRepository cusRepo;

    @Autowired
    private AccountService service;

    @Autowired
    private CustomerService Cusservice;

    @Autowired
    private CategoryService Catservice;


    @PostMapping("/addAccount")
    public String add(@RequestBody Account account){
        service.saveAccount(account);
        return "New Account is added";
    }

    @PostMapping("/addAccountbyCusID")
    public String add(@RequestBody AccountRequest accountRequest){
        service.saveAccount(accountRequest);
        return "New Account is added";
    }



    @GetMapping("/getAccount")
    public List<Account> getAccountList(){
        return service.listAll();
    }

    @GetMapping("/getAccountById/{accountId}")
    public Account getCustomerById(@PathVariable Integer accountId){
        return service.getAccountById(accountId);

    }


    @PutMapping("/updateAccount/{accountId}")
    public Account  updateAccount(@PathVariable Integer accountId,@RequestBody Account acc){
        Account accountFromDB= service.getAccountById(accountId);
        accountFromDB.setCategory(acc.getCategory());
        accountFromDB.setCustomer(acc.getCustomer());
        accountFromDB.setValueAmount(acc.getValueAmount());
        accountFromDB.setAccountId(acc.getAccountId());
        accountFromDB.setInsuranceType(acc.getInsuranceType());
        Account updateAc = service.saveAccount(accountFromDB);

        return accountFromDB;
    }


    @DeleteMapping("/deleteAccount/{accId}")
    public String deleteStudent(@PathVariable Integer accId){
        service.deleteAccount(accId);
        return "Account delete successfully";
    }

    @PutMapping("/{accId}/customers/{cusId}")
    Account assignCustomerToAccount(
            @PathVariable Integer accId,
            @PathVariable Integer cusId
    ){
        Account account = service.getAccountById(accId);
        Customer customer = Cusservice.getCustomerById(cusId);
        account.assignCustomer(customer);
        return service.saveAccount(account);
    }

    @PutMapping("/{accId}/category/{categoryID}")
    Account assignCategoryToAccount(
            @PathVariable Integer accId,
            @PathVariable Integer categoryID
    ){
        Account account = service.getAccountById(accId);
        Category category = Catservice.getCategoryById(categoryID);
        account.assignCategory(category);
        return service.saveAccount(account);
    }

}


