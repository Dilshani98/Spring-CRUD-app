package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerRepository cusRepo;

    @Autowired
    private CustomerService service;


    @PostMapping("/addCustomers")
    public String add(@RequestBody Customer customer){
        service.saveCustomer(customer);
        return "New Customer is added";
    }

//    @GetMapping("/customers")
//    public String showCustomerList(Model model){
//        List<Customer> listCustomers= service.listAll();
//        model.addAttribute("listCustomers",listCustomers);
//        return  "customers";
//    }

//
//    @GetMapping("/getcustomers")
//    public Iterable<Customer> listCustomers(){
//        return cusRepo.findAll();
//    }

    @GetMapping("/getcustomers")
    public List<Customer> getCustomerList(){
        return service.listAll();
    }

    @GetMapping("/getCustomerById/{cusId}")
    public Customer getCustomerById(@PathVariable Integer cusId){
        return service.getCustomerById(cusId);

    }


    @PutMapping("/updateCustomer/{cusId}")
    public String  updateCustomer(@PathVariable Integer cusId,@RequestBody Customer customer){
        Customer cusFromDB= service.getCustomerById(cusId);
        cusFromDB.setName(customer.getName());
        cusFromDB.setAddress(customer.getAddress());
        cusFromDB.setPhoneNo(customer.getPhoneNo());
//        cusFromDB.setAccounts(customer.getAccounts());
        Customer updateCus = service.saveCustomer(cusFromDB);

        return "Successfully updated";
    }


    @DeleteMapping("deleteCustomer/{cusId}")
    public String deleteStudent(@PathVariable Integer cusId){
        service.deleteCustomer(cusId);
        return "Customer delete successfully";
    }



}




//package com.example.demo;
//
//        import org.springframework.stereotype.Controller;
//        import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class MainController {
//
//    @GetMapping("")
//    public String showHomePage(){
//        return "index";
//    }
//
//}