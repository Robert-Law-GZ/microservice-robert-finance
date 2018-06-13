package org.robert.microservice.finance.feign;

import org.robert.microservice.finance.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "robert-microservice-account")
public interface AccountFeignClient {
    @RequestMapping(value = "/user/profile/{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);

    @GetMapping(value = "/user/list")
    List<User> userList();
}
