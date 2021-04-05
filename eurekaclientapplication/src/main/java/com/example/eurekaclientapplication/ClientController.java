package com.example.eurekaclientapplication;

import com.example.eurekaclientapplication.model.Client;
import com.example.eurekaclientapplication.model.Manufactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
@RestController
@RequestMapping("/collect")
public class ClientController {
    private List<Manufactory> manufactories;

    @GetMapping(value = "/clients")
    public List<Client> getClients(@RequestParam(value = "manufactoryId") Integer manufactoryId) {
        setManufactory();
        List<List<Client>> collect = getManufactories().stream()
                .filter(m -> m.getId().equals(manufactoryId))
                .map(Manufactory::getClients)
                .collect(Collectors.toList());
        return !collect.isEmpty() ? collect.get(0) : new ArrayList<>();
    }

    @GetMapping(value = "/all")
    public List<Client> getAll() {
        return Arrays.asList(clients());
    }

    private void setManufactory() {
        this.manufactories = Arrays.asList(manufactories());
    }

    private Client[] clients() {
        return new Client[]{
                Client.builder()
                        .id(1)
                        .name("Jack")
                        .build(),
                Client.builder()
                        .id(2)
                        .name("Johny")
                        .build(),
                Client.builder()
                        .id(3)
                        .name("Ketty")
                        .build()
        };
    }

    private Manufactory[] manufactories() {
        return new Manufactory[]{
                Manufactory.builder()
                        .description("Manufactory_1")
                        .id(1)
                        .clients(Arrays.asList(clients()[0], clients()[1]))
                        .build(),
                Manufactory.builder()
                        .description("Manufactory_2")
                        .id(2)
                        .clients(Arrays.asList(clients()[0], clients()[1], clients()[2]))
                        .build()
        };
    }
}
