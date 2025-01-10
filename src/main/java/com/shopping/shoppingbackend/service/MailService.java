package com.shopping.shoppingbackend.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Service
public class MailService {

    public void cancelOrderMail(String shopperEmail, UUID orderId){
        System.out.print("Inside mailservice");
        String path = "http://localhost:8080/api/mail/shopper/cancelOrder";
        path += "?shopperEmail=" + shopperEmail;
        path += "&orderId=" + orderId;

        URI url = URI.create(path);

        RequestEntity request = new RequestEntity(HttpMethod.GET,url);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> res = restTemplate.exchange(request,String.class);
    }
}
