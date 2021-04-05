package com.example.eurekaclientsecondapplication;

import com.example.eurekaclientsecondapplication.model.UserListHisto;
import com.example.eurekaclientsecondapplication.model.UsersViewsParams;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;

@Service
public class RestTemplateStatistics {
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
    }

    public Map<String, UserListHisto.Holder> getCredits(UsersViewsParams usersViewsParams) {
        String url = "https://local.simplex.tv/stats/views/userList/credit";
        ResponseEntity<Map> map = restTemplate.postForEntity(url, usersViewsParams, Map.class);
        return (Map<String, UserListHisto.Holder>) map.getBody();
    }
}
