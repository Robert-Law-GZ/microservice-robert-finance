package org.robert.microservice.finance.controller;

import org.robert.microservice.finance.feign.AccountFeignClient;
import org.robert.microservice.finance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinanceController {
    @Autowired
    private AccountFeignClient accountFeignClient;

    @GetMapping(value = "/account/{id}")
    public User findById(@PathVariable Long id){
        return  accountFeignClient.findById(id);
    }

    @GetMapping(value ="/account/list")
    public List<User> userList(){
        return accountFeignClient.userList();
    }

}
