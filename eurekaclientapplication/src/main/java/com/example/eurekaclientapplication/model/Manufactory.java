package com.example.eurekaclientapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Manufactory {
    private Integer id;
    private String description;
    private List<Client> clients;
}
