package com.example.eurekaclientsecondapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersViewsParams {
    private String from;
    private String to;
    private String pid;
}
