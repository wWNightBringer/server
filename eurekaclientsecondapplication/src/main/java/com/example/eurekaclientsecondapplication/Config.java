package com.example.eurekaclientsecondapplication;

import feign.Contract;
import feign.Feign;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public Feign feign(){
        return Feign.builder()
                .build();
    }
}
