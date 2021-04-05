package com.example.eurekaclientsecondapplication;

import com.example.eurekaclientsecondapplication.model.Client;
import com.example.eurekaclientsecondapplication.model.UserListHisto;
import com.example.eurekaclientsecondapplication.model.UsersViewsParams;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
public class EurekaService {
    private final OpenFeignEurekaClient openFeignEurekaClient;
    private final RestTemplateStatistics restTemplateStatistics;


    public List<Client> run() {
        List<Client> clients = openFeignEurekaClient.getClients(1);
        log.info("Clients {}", clients);
        return clients;
    }

    public Map<String, UserListHisto.Holder> getCredits() {
        return restTemplateStatistics.getCredits(
                new UsersViewsParams("2021-02-20T22:00:00", "2021-04-01T21:59:59", "272"));
    }
}
