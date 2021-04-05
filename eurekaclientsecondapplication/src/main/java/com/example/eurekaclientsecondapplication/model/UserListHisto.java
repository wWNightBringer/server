package com.example.eurekaclientsecondapplication.model;

import lombok.Data;

import java.util.List;

@Data
public class UserListHisto  {
    private List<Holder> buckets;

    @Data
    public static class Holder {
        private String time;
        private String percentage;
        private String userUID;
    }
}
