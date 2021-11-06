package com.example.demo.service;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer saveCustomer(Customer customer)
    {
       return repo.save(customer);
    }



    public  List<Customer> listAll(){
        return (List<Customer>) repo.findAll();
    }

    public Customer getCustomerById(Integer cusId){
        return  repo.findById(cusId).get();
    }

    public  void deleteCustomer(Integer cusId){
        repo.deleteById(cusId);
    }
}
