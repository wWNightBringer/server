package com.example.eurekaclientsecondapplication.model;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private Integer id;
    private String name;
}
