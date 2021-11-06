package com.example.demo.controller;


import com.example.demo.model.Category;

import com.example.demo.repository.CategoryRepository;

import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryRepository catRepo;

    @Autowired
    private CategoryService service;


    @PostMapping("/addcategory")
    public String add(@RequestBody Category account){
        service.saveAccount(account);
        return "New Category is added";
    }


    @GetMapping("/getCategory")
    public List<Category> getCustomerList(){
        return service.listAll();
    }

    @GetMapping("/getAccountById/{categoryID}")
    public Category getCustomerById(@PathVariable Integer categoryID){
        return service.getCategoryById(categoryID);

    }


    @PutMapping("/updateAccount/{categoryID}")
    public String  updateAccount(@PathVariable Integer categoryID,@RequestBody Category acc){
        Category accountFromDB= service.getCategoryById(categoryID);
        accountFromDB.setName(acc.getName());
        accountFromDB.setDescription(acc.getDescription());
        accountFromDB.setCategoryID(acc.getCategoryID());

        Category updateCat = service.saveAccount(accountFromDB);

        return "Successfully updated";
    }


    @DeleteMapping("deleteCategory/{categoryID}")
    public String deleteStudent(@PathVariable Integer categoryID){
        service.deleteAccount(categoryID);
        return "Customer delete successfully";
    }
}
