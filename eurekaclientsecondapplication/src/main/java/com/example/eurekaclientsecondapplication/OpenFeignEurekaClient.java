package com.example.eurekaclientsecondapplication;

import com.example.eurekaclientsecondapplication.model.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "http://spring-cloud-eureka-client:8082", configuration = Config.class)
public interface OpenFeignEurekaClient {
    @RequestMapping(value = "/collect/clients", method = RequestMethod.GET)
    List<Client> getClients(@RequestParam(value = "manufactoryId") Integer manufactoryId);
}
