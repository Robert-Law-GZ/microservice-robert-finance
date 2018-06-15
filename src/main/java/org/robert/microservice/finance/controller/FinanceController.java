package org.robert.microservice.finance.controller;

import org.robert.microservice.finance.feign.AccountFeignClient;
import org.robert.microservice.finance.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FinanceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FinanceController.class);
    private static String ACCOUNT_SERVICE_NAME = "robert-microservice-account";

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/account/{id}")
    public User findById(@PathVariable Long id){
        List<ServiceInstance> list = discoveryClient.getInstances(ACCOUNT_SERVICE_NAME);
        ServiceInstance serviceInstance = list.get(0);
        FinanceController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return  accountFeignClient.findById(id);
    }

    @GetMapping(value ="/account/list")
    public List<User> userList(){
        List<ServiceInstance> list = discoveryClient.getInstances(ACCOUNT_SERVICE_NAME);
        ServiceInstance serviceInstance = list.get(0);
        FinanceController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        return accountFeignClient.userList();
    }

}
