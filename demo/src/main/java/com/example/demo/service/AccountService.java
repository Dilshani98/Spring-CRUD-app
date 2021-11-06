package com.example.demo.service;


import com.example.demo.Pojos.AccountRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AccountService {

    @Autowired
    private AccountRepository repo;
    @Autowired
    private CustomerRepository cusrepo;

    @Autowired
    private CustomerService cuserv;

    @Autowired
    private CategoryService catser;

    public Account saveAccount(Account account)
    {

        return repo.save(account);
    }



    public  List<Account> listAll(){
       return (List<Account>) repo.findAll();
    }

    public Account getAccountById(Integer accountId){
        return  repo.findById(accountId).get();
    }

    public  void deleteAccount(Integer accountId){
        repo.deleteById(accountId);
    }

    public void saveAccount(AccountRequest accountRequest) {
        Customer customer =cuserv.getCustomerById(accountRequest.customer);
        Category category =catser.getCategoryById(accountRequest.category);
        Account account = new Account();
        account.setInsuranceType(accountRequest.InsuranceType);
        account.setValueAmount(accountRequest.valueAmount);
        account.setCustomer(customer);
        account.setCategory(category);
         repo.save(account);

    }
}
