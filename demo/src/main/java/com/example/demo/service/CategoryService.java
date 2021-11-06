package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.model.Category;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category saveAccount(Category account)
    {
        return repo.save(account);
    }



    public List<Category> listAll(){
        return (List<Category>) repo.findAll();
    }

    public Category getCategoryById(Integer categoryID){
        return  repo.findById(categoryID).get();
    }

    public  void deleteAccount(Integer categoryID){
        repo.deleteById(categoryID);
    }
}
