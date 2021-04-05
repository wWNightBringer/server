package com.example.eurekaclientsecondapplication;

import com.example.eurekaclientsecondapplication.model.Client;
import com.example.eurekaclientsecondapplication.model.UserListHisto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    private EurekaService eurekaService;

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(eurekaService.run());
    }

    @GetMapping(value = "/credits")
    public ResponseEntity<Map<String, UserListHisto.Holder>> getCredits() {
        return ResponseEntity.ok(eurekaService.getCredits());
    }
}
